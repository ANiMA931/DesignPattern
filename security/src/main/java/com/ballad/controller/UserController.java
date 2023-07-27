package com.ballad.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.ballad.security.entity.User;
import com.ballad.security.service.UserService;
import com.ballad.utils.JwtUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    private UserService userService;

    /**
     * @param user user对象，默认有值
     * @description 登录功能
     * @author xBaozi
     * @date 0:02 2022/4/1
     **/
    @GetMapping("/login")
    public Map<String, Object> login(User user) {
        log.info("用户名: [{}]", user.getUserName());
        log.info("密码: [{}]", user.getPassword());
        Map<String, Object> map = new HashMap<>();
        User trueUser = userService.getOne(
                new QueryWrapper<User>().eq("user_name", user.getUserName())
        );
        if (trueUser == null) {
            map.put("state", false);
            map.put("msg", "用户名不存在");
            return map;
        }
        try {
            Map<String, String> payload = new HashMap<>();
            payload.put("id", String.valueOf(user.getId()));
            payload.put("userName", user.getUserName());
            // 生成JWT的令牌
            String token = JwtUtils.createToken(payload);
            map.put("state", true);
            map.put("msg", "认证成功");
            // 响应token
            map.put("token", token);
        } catch (Exception e) {
            map.put("state", false);
            map.put("msg", e.getMessage());
        }
        return map;
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
