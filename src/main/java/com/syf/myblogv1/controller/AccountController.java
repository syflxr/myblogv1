package com.syf.myblogv1.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.syf.myblogv1.common.Result;
import com.syf.myblogv1.entity.LoginVo;
import com.syf.myblogv1.entity.User;
import com.syf.myblogv1.service.UserService;
import com.syf.myblogv1.util.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: shenyafeng
 * @Date: 2022/1/15 13:29
 * @Description:
 */

@RestController
public class AccountController {
    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping("/login")
    public Result login(@RequestBody LoginVo loginDto, HttpServletResponse response) {
        System.out.println(JSON.toJSONString(loginDto));
        User user = userService.getBaseMapper().selectOne(new QueryWrapper<User>().eq("username", loginDto.getUsername()));


        Assert.notNull(user, "用户不存在");
        if(!user.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))) {
            return Result.fail("密码错误！");
        }
        String jwt = jwtUtils.generateToken(user.getId());
        response.setHeader("Authorization", jwt);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        // 用户可以另一个接口
        //MarkerHub 111111
        return Result.succ(MapUtil.builder()
                .put("id", user.getId())
                .put("username", user.getUsername())
                .put("avatar", user.getAvatar())
                .put("email", user.getEmail())
                .map()
        );
    }

    @CrossOrigin
    @GetMapping("/loginTest")
    public Result login1() {
        return Result.succ("success",null);
    }

    // 退出
    @GetMapping("/logout")
    @RequiresAuthentication
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return Result.succ(null);
    }
}
