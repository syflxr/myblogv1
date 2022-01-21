package com.syf.myblogv1.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.syf.myblogv1.entity.User;
import com.syf.myblogv1.service.UserService;
import com.syf.myblogv1.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: shenyafeng
 * @Date: 2022/1/15 11:32
 * @Description:
 */

@Slf4j
@Component
public class AccountRealm extends AuthorizingRealm {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    UserService userService;
    //支持对该种token的校验
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * @description: 登录认证校验
     * @param:
     * @param token
     * @return: org.apache.shiro.authc.AuthenticationInfo
     * @author shenyafeng
     * @date: 2022/1/15 12:46
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtToken jwt = (JwtToken) token;
        log.info("jwt----------------->{}", jwt);
        String userId = jwtUtils.getClaimByToken((String) jwt.getPrincipal()).getSubject();
        User user = userService.getBaseMapper().selectById(Long.parseLong(userId));
        if(user == null) {
            throw new UnknownAccountException("账户不存在！");
        }
        if(user.getStatus() == -1) {
            throw new LockedAccountException("账户已被锁定！");
        }
        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(user, profile);
        log.info("profile----------------->{}", profile.toString());
        return new SimpleAuthenticationInfo(profile, jwt.getCredentials(), getName());
    }

    /**
     * @description: 权限校验
     * @param:
     * @param principals
     * @return: org.apache.shiro.authz.AuthorizationInfo
     * @author shenyafeng
     * @date: 2022/1/15 12:47
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

}
