package com.ballad.statemachine.config;

import com.ballad.statemachine.event.RegEventEnum;
import com.ballad.statemachine.handler.SysUserPersistStateChangeListener;
import com.ballad.statemachine.handler.SysUserPersistStateMachineHandler;
import com.ballad.statemachine.service.SysUserStateService;
import com.ballad.statemachine.state.RegStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;

@Configuration
public class SysUserPersistHandlerConfig {

    @Autowired
    private StateMachine<RegStatusEnum, RegEventEnum> stateMachine;


    @Bean
    public SysUserStateService sysUserStateService() {
        SysUserPersistStateMachineHandler handler = persistStateMachineHandler();
        handler.addPersistStateChangeListener(persistStateChangeListener());
        //由于此处已经定义了bean，所以在具体的SysUserStateService中，就不需要再用注解@component了
        return new SysUserStateService(handler);
    }

    @Bean
    public SysUserPersistStateMachineHandler persistStateMachineHandler() {
        return new SysUserPersistStateMachineHandler(stateMachine);
    }

    @Bean
    public SysUserPersistStateChangeListener persistStateChangeListener(){
        return new SysUserPersistStateChangeListener();
    }
}
