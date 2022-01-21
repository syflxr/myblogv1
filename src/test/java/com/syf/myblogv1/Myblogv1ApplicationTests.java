package com.syf.myblogv1;


import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import com.syf.myblogv1.entity.Blog;
import com.syf.myblogv1.entity.User;
import com.syf.myblogv1.mapper.UserMapper;
import com.syf.myblogv1.service.BlogService;
import com.syf.myblogv1.service.UserService;
import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootTest
class Myblogv1ApplicationTest{
   @Autowired
    private UserService userService;

   @Autowired
   private BlogService blogService;
   @Test
    public void testGetUser(){
       System.out.println("begin test");
       List<User> users = userService.getBaseMapper().selectList(null);
       System.out.println(JSON.toJSONString(users));

   }

   @Test
    public void testWriteBlog() throws InterruptedException {
      for(int i=0;1<10;i++){
         Thread.sleep(500);
         Blog blog=new Blog();
         blog.setContent("这是内容"+i);
         blog.setDescription("这是描述"+i);
         blog.setTitle("title"+i);
         blog.setCreated(new Date());
         blog.setUserId(1L);
         blog.setStatus(1);
         blogService.getBaseMapper().insert(blog);
      }

   }


}
