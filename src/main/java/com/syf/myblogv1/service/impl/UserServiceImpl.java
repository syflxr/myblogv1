package com.syf.myblogv1.service.impl;

import com.syf.myblogv1.entity.User;
import com.syf.myblogv1.mapper.UserMapper;
import com.syf.myblogv1.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
