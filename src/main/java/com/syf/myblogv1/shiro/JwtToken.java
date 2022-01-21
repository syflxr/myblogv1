package com.syf.myblogv1.shiro;/**
 * @Auther: shenyafeng
 * @Date: 2022/1/15 11:06
 * @Description:
 */

import org.apache.shiro.authc.AuthenticationToken;

/**
 *@ClassName $ {name}
 *@Description TODO
 *@Author $ {USER}
 *@Date $ {DATE} 11:06
 *@Version 1.0
 **/
public class JwtToken implements AuthenticationToken {
    private String token;
    public JwtToken(String token) {
        this.token = token;
    }
    @Override
    public Object getPrincipal() {
        return token;
    }
    @Override
    public Object getCredentials() {
        return token;
    }
}
