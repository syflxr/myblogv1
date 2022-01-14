package com.syf.myblogv1;


import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import com.syf.myblogv1.entity.User;
import com.syf.myblogv1.mapper.UserMapper;
import com.syf.myblogv1.service.UserService;
import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@SpringBootTest
class Myblogv1ApplicationTest{
   @Autowired
    private UserService userService;

   @Test
    public void testGetUser(){
       System.out.println("begin test");
       List<User> users = userService.getBaseMapper().selectList(null);
       System.out.println(JSON.toJSONString(users));

   }

}
