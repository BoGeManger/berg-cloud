package com.berg.auth.system.auth;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.DES;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.berg.auth.system.constant.SystemConstants;
import com.berg.common.constant.RedisKeyConstants;
import com.berg.dao.system.sys.entity.ComponentTbl;
import com.berg.dao.system.sys.entity.UserTbl;
import com.berg.dao.system.sys.service.ComponentTblDao;
import com.berg.dao.system.sys.service.RoleTblDao;
import com.berg.dao.system.sys.service.UserTblDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
public class AuthorizingRealm {

    @Autowired
    AuthenticationUtil authenticationUtil;

    @Autowired
    SystemConstants systemConstants;
    @Autowired
    StringRedisTemplate stringTemplate;

    @Autowired
    UserTblDao userTblDao;
    @Autowired
    RoleTblDao roleTblDao;
    @Autowired
    ComponentTblDao componentTblDao;

    /**
     * 授权模块，判断是否验证授权
     *
     * @param username
     * @param permission
     * @return
     */
    public Boolean isPermitted(String username, String permission) {
        Boolean flag = false;
        String[] accounts = StringUtils.splitByWholeSeparatorPreserveAllTokens(systemConstants.getAccounts(), ",");
        for (String a : accounts) {
            if (a.equals(username)){
                flag = true;
                break;
            }
        }
        if(!flag){
            flag = doGetAuthorizationInfo(username);
        }
        return flag;
    }

    /**
     * 授权模块，获取用户角色和权限判断授权
     *
     * @param username
     * @return
     */
    public Boolean doGetAuthorizationInfo(String username) {
        Boolean flag = false;
        // 获取用户角色集
        Set<String> roleSet = getUserRoles(username);
        // 获取用户权限集
        Set<String> permissionSet = getUserPerms(username);
        return flag;
    }

    /**
     * 获取用户角色
     * @param userName
     * @return
     */
    public Set<String> getUserRoles(String userName) {
        List<String> list = new ArrayList<>();
        String key = String.format(RedisKeyConstants.System.USER_ROLE, userName);
        String value = stringTemplate.opsForValue().get(key);
        if (StringUtils.isNotBlank(value)) {
            list = JSON.parseArray(stringTemplate.opsForValue().get(key), String.class);
        } else {
            list = roleTblDao.getMapper().listUserRoleName(userName);
            stringTemplate.opsForValue().set(key,JSON.toJSONString(list),systemConstants.getExpireTime(), TimeUnit.SECONDS);
        }
        return list.stream().collect(Collectors.toSet());
    }

    /**
     * 获取用户权限
     * @param userName
     * @return
     */
    public Set<String> getUserPerms(String userName) {
        List<String> list = new ArrayList<>();
        String key = String.format(RedisKeyConstants.System.USER_PERMS, userName);
        String value = stringTemplate.opsForValue().get(key);
        if (StringUtils.isNotBlank(value)) {
            list = JSON.parseArray(value, String.class);
        } else {
            if(checkAccount(userName)){
                LambdaQueryWrapper query = new QueryWrapper<ComponentTbl>().select("perms").lambda()
                        .eq(ComponentTbl::getIsdel,0);
                list = componentTblDao.listObjs(query);
            }else {
                list = componentTblDao.getMapper().listUserPerms(userName);
            }
            stringTemplate.opsForValue().set(key,JSON.toJSONString(list),systemConstants.getExpireTime(), TimeUnit.SECONDS);
        }
        return list.stream().collect(Collectors.toSet());
    }

    /**
     * 判断是否超级用户
     * @param userName
     * @return
     */
    Boolean checkAccount(String userName){
        Boolean flag = false;
        String[] accounts = StringUtils.splitByWholeSeparatorPreserveAllTokens(systemConstants.getAccounts(), ",");
        for (String a : accounts) {
            if (a.equals(userName))
                flag = true;
        }
        return  flag;
    }

    /**
     * 用户认证
     * @param token
     * @throws AuthenticationException
     */
    public void doGetAuthenticationInfo(String token) throws AuthenticationException{
        String encryptToken = authenticationUtil.DES.decryptStr(token.toLowerCase());
        String username = authenticationUtil.getUsername(encryptToken);
        String key = String.format(RedisKeyConstants.System.SYSTEM_TOKEN, token);
        if (!stringTemplate.hasKey(key)) {
            throw new AuthenticationException("token已经过期");
        }
        if (StringUtils.isBlank(username))
            throw new AuthenticationException("token校验不通过");


        // 通过用户名查询用户信息
        UserTbl userTbl = userTblDao.getOne(new LambdaQueryWrapper<UserTbl>().eq(UserTbl::getUsername, username));
        if (userTbl == null)
            throw new AuthenticationException("用户名或密码错误");
        if (!authenticationUtil.verify(encryptToken, username, userTbl.getPassword()))
            throw new AuthenticationException("token校验不通过");
    }

}
