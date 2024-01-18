package com.ballad.statemachine.config;

import com.ballad.statemachine.event.RegEventEnum;
import com.ballad.statemachine.state.RegStatusEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

@Configuration
@EnableStateMachine // 开启状态机配置
/**
 * 状态机配置类
 * 需要再继承适配器中指明状态机状态和状态转换事件
 */
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<RegStatusEnum, RegEventEnum> {

    /**
     * 配置状态机状态
     */
    @Override
    public void configure(StateMachineStateConfigurer<RegStatusEnum, RegEventEnum> states) throws Exception {
        states.withStates()
                // 初始化状态机状态
                .initial(RegStatusEnum.UNCONNECTED)
                // 指定状态机的所有状态
                .states(EnumSet.allOf(RegStatusEnum.class));
    }

    /**
     * 配置状态机状态转换
     */
    @Override
    public void configure(StateMachineTransitionConfigurer<RegStatusEnum, RegEventEnum> transitions) throws Exception {
        // 1. connect UNCONNECTED -> CONNECTED
        transitions.withExternal()
                .source(RegStatusEnum.UNCONNECTED)
                .target(RegStatusEnum.CONNECTED)
                .event(RegEventEnum.CONNECT)
                // 2. beginToLogin CONNECTED -> LOGINING
                .and().withExternal()
                .source(RegStatusEnum.CONNECTED)
                .target(RegStatusEnum.LOGINING)
                .event(RegEventEnum.BEGIN_TO_LOGIN)
                // 3. login failure LOGINING -> UNCONNECTED
                .and().withExternal()
                .source(RegStatusEnum.LOGINING)
                .target(RegStatusEnum.UNCONNECTED)
                .event(RegEventEnum.LOGIN_FAILURE)
                // 4. login success LOGINING -> LOGIN_INTO_SYSTEM
                .and().withExternal()
                .source(RegStatusEnum.LOGINING)
                .target(RegStatusEnum.LOGIN_INTO_SYSTEM)
                .event(RegEventEnum.LOGIN_SUCCESS)
                // 5. logout LOGIN_INTO_SYSTEM -> UNCONNECTED
                .and().withExternal()
                .source(RegStatusEnum.LOGIN_INTO_SYSTEM)
                .target(RegStatusEnum.UNCONNECTED)
                .event(RegEventEnum.LOGOUT);
    }
}