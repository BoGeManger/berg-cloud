package com.berg.system.service.request.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.berg.dao.page.PageInfo;
import com.berg.dao.system.res.entity.ApiTbl;
import com.berg.dao.system.res.service.ApiTblDao;
import com.berg.exception.UserFriendException;
import com.berg.system.auth.JWTUtil;
import com.berg.system.service.request.ApiService;
import com.berg.vo.request.ApiEditVo;
import com.berg.vo.request.ApiVo;
import com.berg.vo.request.in.GetApiPageInVo;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Data
@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    JWTUtil jWTUtil;
    @Autowired
    ApiTblDao apiTblDao;

    /**
     * 获取请求接口分页列表
     * @param input
     * @return
     */
    @Override
    public PageInfo<ApiVo> getApiPage(GetApiPageInVo input){
        PageInfo<ApiVo> page = apiTblDao.page(input,()->{
            QueryWrapper query = new QueryWrapper<ApiTbl>()
                    .eq("isdel",0);
            if(StringUtils.isNotBlank(input.getServiceName())){
                query.like("service_name",input.getServiceName());
            }
            if(StringUtils.isNotBlank(input.getRemark())){
                query.like("remark",input.getRemark());
            }
            query.orderByDesc("modify_time");
            return apiTblDao.list(query,ApiVo.class);
        });
        return page;
    }

    /**
     * 获取请求接口
     * @param id
     * @return
     */
    @Override
    public ApiEditVo getApi(Integer id){
        ApiEditVo result = apiTblDao.getById(id,ApiEditVo.class);
        return  result;
    }

    /**
     *  新增请求接口
     * @param input
     * @return
     */
    @Override
    public Integer addApi(ApiEditVo input){
        checkServiceAndPath(input);
        String operator = jWTUtil.getUsername();
        Integer apiId = addOrUpdateApi(input,operator);
        return  apiId;
    }

    /**
     * 修改请求接口
     * @param input
     * @return
     */
    @Override
    public Integer updateApi(ApiEditVo input){
        checkServiceAndPath(input);
        String operator = jWTUtil.getUsername();
        Integer apiId = addOrUpdateApi(input,operator);
        return  apiId;
    }

    /**
     * 校验存在
     * @param input
     */
    void checkServiceAndPath(ApiEditVo input){
        LambdaQueryWrapper<ApiTbl> query = new LambdaQueryWrapper<ApiTbl>().eq(ApiTbl::getServiceName,input.getServiceName())
                .eq(ApiTbl::getController,input.getController())
                .eq(ApiTbl::getMethod,input.getMethod())
                .eq(ApiTbl::getIsdel,0);
        if(!input.getId().equals(0)){
            query.ne(ApiTbl::getId,input.getId());
        }
        if(apiTblDao.count(query)>0){
            throw new UserFriendException("调用服务地址已存在");
        }
    }

    /**
     * 新增或修改请求接口
     * @param input
     * @param operator
     * @return
     */
    Integer addOrUpdateApi(ApiEditVo input,String operator){
        LocalDateTime now = LocalDateTime.now();
        Boolean isAdd = input.getId()==0?true:false;
        ApiTbl apiTbl = new ApiTbl();
        apiTbl.setId(input.getId());
        apiTbl.setServiceName(input.getServiceName());
        apiTbl.setController(input.getController());
        apiTbl.setMethod(input.getMethod());
        apiTbl.setRemark(input.getRemark());
        apiTbl.setModifyTime(now);
        apiTbl.setModifyUser(operator);
        if(isAdd){
            apiTbl.setCreateTime(now);
            apiTbl.setCreateUser(operator);
            apiTbl.setIsdel(0);
        }
        apiTblDao.saveOrUpdateById(apiTbl);
        return apiTbl.getId();
    }

    /**
     * 删除请求接口
     * @param id
     */
    @Override
    public void delApi(Integer id){
        LocalDateTime now = LocalDateTime.now();
        String operator = jWTUtil.getUsername();
        ApiTbl apiTbl = apiTblDao.getById(id);
        if(apiTbl!=null){
            apiTbl.setDelTime(now);
            apiTbl.setDelUser(operator);
            apiTbl.setIsdel(1);
            apiTblDao.updateById(apiTbl);
        }
    }
}
