package com.ballad.statemachine.config;

import com.ballad.statemachine.event.RegEventEnum;
import com.ballad.statemachine.handler.OrderPersistStateChangeListener;
import com.ballad.statemachine.handler.PersistStateMachineHandler;
import com.ballad.statemachine.service.SysUserStateService;
import com.ballad.statemachine.state.RegStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;

@Configuration
public class OrderPersistHandlerConfig {

    @Autowired
    private StateMachine<RegStatusEnum, RegEventEnum> stateMachine;


    @Bean
    public SysUserStateService persist() {
        PersistStateMachineHandler handler = persistStateMachineHandler();
        handler.addPersistStateChangeListener(persistStateChangeListener());
        return new SysUserStateService(handler);
    }

    @Bean
    public PersistStateMachineHandler persistStateMachineHandler() {
        return new PersistStateMachineHandler(stateMachine);
    }

    @Bean
    public OrderPersistStateChangeListener persistStateChangeListener(){
        return new OrderPersistStateChangeListener();
    }
}
