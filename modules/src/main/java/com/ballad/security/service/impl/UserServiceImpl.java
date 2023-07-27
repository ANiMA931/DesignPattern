package com.ballad.security.service.impl;

import com.ballad.security.dao.UserDao;
import com.ballad.security.entity.User;
import com.ballad.security.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
}
