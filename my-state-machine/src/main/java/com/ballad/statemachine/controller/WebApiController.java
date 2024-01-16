package com.ballad.statemachine.controller;

import com.ballad.statemachine.event.RegEventEnum;
import com.ballad.statemachine.state.RegStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebApiController {

    @Autowired
    private StateMachine<RegStatusEnum, RegEventEnum> stateMachine;

    @GetMapping(value = "/testStateMachine")
    public void testStateMachine()
    {
        stateMachine.start();
        stateMachine.sendEvent(RegEventEnum.CONNECT);
        stateMachine.sendEvent(RegEventEnum.BEGIN_TO_LOGIN);
        stateMachine.sendEvent(RegEventEnum.LOGIN_FAILURE);
        stateMachine.sendEvent(RegEventEnum.LOGOUT);
    }
}