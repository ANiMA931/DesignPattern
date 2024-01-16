package com.ballad.statemachine.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * 事件配置类，用于配置状态机的事件转换监听
 *
 * @WithStateMachine 注解用于开启状态机配置
 * @Configuration 注解用于开启配置
 */
@Configuration
@WithStateMachine
public class StateMachineEventConfig {

    Logger log = LoggerFactory.getLogger(getClass());


    @OnTransition(source = "UNCONNECTED", target = "CONNECTED")
    public void connect() {
        log.info("将状态从UNCONNECTED（未连接）转换为CONNECTED（已连接）。");
    }

    @OnTransition(source = "CONNECTED", target = "LOGINING")
    public void beginToLogin() {
        log.info("将状态从CONNECTED（已连接）转换为LOGINING（登录中），开始登录begin to login");

    }

    @OnTransition(source = "LOGINING", target = "LOGIN_INTO_SYSTEM")
    public void loginSuccess() {
        log.info("将状态从LOGINING（登录中）转换为LOGIN_INTO_SYSTEM（已登录系统），登录成功（login success）");
    }

    @OnTransition(source = "LOGINING", target = "UNCONNECTED")
    public void loginFailure() {
        log.info("将状态从LOGINING（登录中）转换为UNCONNECTED（未连接），登录失败（login failed）");
    }

    @OnTransition(source = "LOGIN_INTO_SYSTEM", target = "UNCONNECTED")
    public void logout() {
        log.info("将状态从LOGIN_INTO_SYSTEM（已登录）转换为UNCONNECTED（未连接），登出（logout）。");
    }
}

