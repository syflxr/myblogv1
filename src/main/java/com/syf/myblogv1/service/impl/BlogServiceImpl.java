package com.syf.myblogv1.service.impl;

import com.syf.myblogv1.entity.Blog;
import com.syf.myblogv1.mapper.BlogMapper;
import com.syf.myblogv1.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shenyafeng
 * @since 2022-01-14
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
