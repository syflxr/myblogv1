package com.syf.myblogv1.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Auther: shenyafeng
 * @Date: 2022/1/14 22:01
 * @Description:
 */

@Configuration
@EnableTransactionManagement
@MapperScan("com.syf.myblogv1")
public class MyBatisPlusConfig {
    /**
     * @description: 一个分页插件
     * @param:
     * @return: com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     * @author shenyafeng
     * @date: 2022/1/14 22:06
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }

}
