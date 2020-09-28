package com.berg.system.service.request.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.berg.constant.RedisKeyConstants;
import com.berg.dao.page.PageInfo;
import com.berg.dao.system.res.entity.ApplicationApiTbl;
import com.berg.dao.system.res.entity.ApplicationTbl;
import com.berg.dao.system.res.service.ApplicationApiTblDao;
import com.berg.dao.system.res.service.ApplicationTblDao;
import com.berg.exception.UserFriendException;
import com.berg.system.authentication.JWTUtil;
import com.berg.system.service.request.ApplicationService;
import com.berg.utils.SnowflakeIdWorker;
import com.berg.vo.request.ApplicationEditVo;
import com.berg.vo.request.ApplicationVo;
import com.berg.vo.request.in.GetApplicationPageInVo;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class ApplicationServiceImpl implements ApplicationService {


    @Autowired
    JWTUtil jWTUtil;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    ApplicationApiTblDao applicationApiTblDao;
    @Autowired
    ApplicationTblDao applicationTblDao;

    /**
     * 获取请求应用分页列表
     * @param input
     * @return
     */
    @Override
    public PageInfo<ApplicationVo> getApplicationPage(GetApplicationPageInVo input){
        PageInfo<ApplicationVo> page = applicationTblDao.page(input,()->{
            QueryWrapper query = new QueryWrapper<ApplicationTbl>()
                    .eq("isdel",0);
            if(StringUtils.isNotBlank(input.getName())){
                query.like("name",input.getName());
            }
            if(StringUtils.isNotBlank(input.getRemark())){
                query.like("remark",input.getRemark());
            }
            query.orderByDesc("modify_time");
            return applicationTblDao.list(query,ApplicationVo.class);
        });
        return page;
    }

    /**
     * 获取请求应用
     * @param id
     * @return
     */
    @Override
    public ApplicationEditVo getApplication(Integer id){
        ApplicationEditVo result = applicationTblDao.getById(id,ApplicationEditVo.class);
        if(result!=null){
            LambdaQueryWrapper query = new QueryWrapper<ApplicationApiTbl>().select("api_id").lambda()
                    .eq(ApplicationApiTbl::getAppId,id)
                    .eq(ApplicationApiTbl::getIsdel,0);
            result.setApiIds(applicationApiTblDao.listObjs(query));
        }
        return  result;
    }

    /**
     * 新增请求应用
     * @param input
     * @return
     */
    @DS("system")
    @Transactional
    @Override
    public Integer addApplication(ApplicationEditVo input){
        checkName(input);
        String operator = jWTUtil.getUsername();
        Integer appId = addOrUpdateApplication(input,operator);
        if(input.getApiIds().size()>0){
            addOrUpdateApplicationApi(appId,input.getApiIds(),operator);
        }
        return  appId;
    }

    /**
     * 修改请求应用
     * @param input
     * @return
     */
    @DS("system")
    @Transactional
    @Override
    public Integer updateApplication(ApplicationEditVo input){
        checkName(input);
        String operator = jWTUtil.getUsername();
        Integer appId = addOrUpdateApplication(input,operator);
        if(input.getApiIds().size()>0){
            addOrUpdateApplicationApi(appId,input.getApiIds(),operator);
        }
        delApplicationApiCache(input.getName());
        return  appId;
    }

    /**
     * 校验存在
     * @param input
     */
    void checkName(ApplicationEditVo input){
        LambdaQueryWrapper<ApplicationTbl> query = new LambdaQueryWrapper<ApplicationTbl>().eq(ApplicationTbl::getName,input.getName())
                .eq(ApplicationTbl::getIsdel,0);
        if(!input.getId().equals(0)){
            query.ne(ApplicationTbl::getId,input.getId());
        }
        if(applicationTblDao.count(query)>0){
            throw new UserFriendException("应用名称已存在");
        }
    }

    /**
     * 新增或修改请求应用
     * @param input
     * @param operator
     * @return
     */
    Integer addOrUpdateApplication(ApplicationEditVo input,String operator) {
        LocalDateTime now = LocalDateTime.now();
        Boolean isAdd = input.getId() == 0 ? true : false;
        ApplicationTbl applicationTbl = new ApplicationTbl();
        applicationTbl.setId(input.getId());
        applicationTbl.setName(input.getName());
        applicationTbl.setRemark(input.getRemark());
        applicationTbl.setModifyTime(now);
        applicationTbl.setModifyUser(operator);
        if(isAdd){
            applicationTbl.setSecret(DigestUtil.md5Hex16(SnowflakeIdWorker.getStrUid()));
            applicationTbl.setCreateTime(now);
            applicationTbl.setCreateUser(operator);
            applicationTbl.setIsdel(0);
        }
        applicationTblDao.saveOrUpdateById(applicationTbl);
        return applicationTbl.getId();
    }

    /**
     * 新增或修改请求应用接口
     * @param appId
     * @param apiIds
     * @param operator
     */
    void addOrUpdateApplicationApi(Integer appId, List<Integer> apiIds, String operator){
        LocalDateTime now = LocalDateTime.now();
        LambdaQueryWrapper query = new LambdaQueryWrapper<ApplicationApiTbl>()
                .eq(ApplicationApiTbl::getAppId,appId)
                .eq(ApplicationApiTbl::getIsdel,0);
        List<ApplicationApiTbl> updateList = applicationApiTblDao.list(query);
        //作废原有数据
        if(updateList.size()>0){
            updateList.forEach(item->{
                item.setIsdel(1);
                item.setDelTime(now);
                item.setDelUser(operator);
            });
            applicationApiTblDao.updateBatchById(updateList);
        }
        List<ApplicationApiTbl> addList = new ArrayList<>();
        //新增请求接口数据
        apiIds.forEach(item->{
            ApplicationApiTbl applicationApiTbl = new ApplicationApiTbl();
            applicationApiTbl.setAppId(appId);
            applicationApiTbl.setApiId(item);
            applicationApiTbl.setCreateTime(now);
            applicationApiTbl.setCreateUser(operator);
            applicationApiTbl.setDelTime(now);
            applicationApiTbl.setDelUser(operator);
            applicationApiTbl.setIsdel(0);
            addList.add(applicationApiTbl);
        });
        applicationApiTblDao.saveBatch(addList);
    }

    /**
     * 删除请求应用
     * @param id
     */
    @Override
    public void delApplication(Integer id){
        LocalDateTime now = LocalDateTime.now();
        String operator = jWTUtil.getUsername();
        ApplicationTbl applicationTbl = applicationTblDao.getById(id);
        if(applicationTbl!=null){
            applicationTbl.setDelTime(now);
            applicationTbl.setDelUser(operator);
            applicationTbl.setIsdel(1);
            applicationTblDao.updateById(applicationTbl);
        }
        delApplicationApiCache(applicationTbl.getName());
    }

    /**
     * 删除请求应用接口缓存
     * @param name
     */
    void delApplicationApiCache(String name){
        String key = String.format(RedisKeyConstants.Request.APPLICATION_API,name);
        stringRedisTemplate.delete(key);
    }

    /**
     * 修改请求应用密钥
     * @param id
     */
    @Override
    public void updateApplicationSecret(Integer id){
        LambdaUpdateWrapper update = new LambdaUpdateWrapper<ApplicationTbl>()
                .eq(ApplicationTbl::getId,id)
                .set(ApplicationTbl::getSecret,DigestUtil.md5Hex16(SnowflakeIdWorker.getStrUid()));
        applicationTblDao.update(update);
    }
}
