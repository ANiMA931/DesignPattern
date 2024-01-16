package com.ballad.security.service.impl;

import com.ballad.security.dao.UserDao;
import com.ballad.security.entity.SysUser;
import com.ballad.security.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<UserDao, SysUser> implements SysUserService {
}
