package com.ballad.intercepter;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.ballad.common.BaseResponse;
import com.ballad.common.ErrorCode;
import com.ballad.common.ResultUtils;
import com.ballad.redis.RedisService;
import com.ballad.utils.JwtUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @Classname JwtInterceptor
 * @date 2023-07-13 15:25
 * @comment
 */
public class JwtInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisService redisService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        //获取请求头中令牌
        String token = request.getHeader("token");
        BaseResponse<?> baseResponse;
        try {
            //验证令牌
            JwtUtils.verifyToken(token);
            //验证成功，放行请求
            return true;
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            baseResponse = ResultUtils.error(ErrorCode.TOKEN_INVALID_SIGNATURE);
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            baseResponse = ResultUtils.error(ErrorCode.TOKEN_EXPIRED);
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            baseResponse = ResultUtils.error(ErrorCode.TOKEN_ALG_EXPECTION);
        } catch (Exception e) {
            e.printStackTrace();
            baseResponse = ResultUtils.error(ErrorCode.TOKEN_INVALID);
        }
        //将map转为json
        String json = new ObjectMapper().writeValueAsString(baseResponse);
        // 相应json数据
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false;
    }
}
