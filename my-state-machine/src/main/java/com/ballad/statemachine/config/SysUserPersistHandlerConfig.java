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
    public SysUserStateService persist() {
        SysUserPersistStateMachineHandler handler = persistStateMachineHandler();
        handler.addPersistStateChangeListener(persistStateChangeListener());
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
