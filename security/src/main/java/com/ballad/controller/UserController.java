package com.ballad.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.ballad.common.BaseResponse;
import com.ballad.common.ResultCode;
import com.ballad.common.ResultUtils;
import com.ballad.security.entity.SysUser;
import com.ballad.security.service.SysUserService;
import com.ballad.security.vo.LoginVo;
import com.ballad.utils.JwtUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @Classname UserController
 * @date 2023-07-13 15:27
 * @comment
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * @param sysUser user对象，默认有值
     * @description 登录功能
     * @author xBaozi
     * @date 0:02 2022/4/1
     **/
    @GetMapping("/login")
    public BaseResponse<?> login(@Validated SysUser sysUser) {
        log.info("用户名: [{}]", sysUser.getUserName());
        log.info("密码: [{}]", sysUser.getPassword());
        LoginVo loginVo = new LoginVo();
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", sysUser.getUserName());
        SysUser trueSysUser = sysUserService.getOne(wrapper);
        if (trueSysUser == null) {
            return ResultUtils.error(ResultCode.USER_NOT_EXIST);
        }
        Map<String, String> payload = new HashMap<>();
        payload.put("id", String.valueOf(sysUser.getId()));
        payload.put("userName", sysUser.getUserName());
        try {
            // 生成JWT的令牌
            String token = JwtUtils.createToken(payload);
            // 响应token
            loginVo.setToken(token);
        } catch (Exception e) {
            return ResultUtils.error(ResultCode.TOKEN_CREATE_ERROR);
        }
        return ResultUtils.success(loginVo);
    }

    @PostMapping("/other")
    public Map<String, Object> test(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        //处理自己业务逻辑
        String token = request.getHeader("token");
        DecodedJWT verify = JwtUtils.verifyToken(token);
        log.info("用户id: [{}]", verify.getClaim("id").asString());
        log.info("用户name: [{}]", verify.getClaim("userName").asString());
        map.put("state", true);
        map.put("msg", "请求成功!");
        return map;
    }
}
