package com.org.Demo.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.org.Demo.mp.mappers.UserMapper;
import com.org.Demo.mp.po.User;
import com.org.Demo.mp.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author xujiafu
 * @date 2021/12/5 22:50
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
