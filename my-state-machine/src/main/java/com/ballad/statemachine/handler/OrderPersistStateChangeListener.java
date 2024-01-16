package com.ballad.statemachine.handler;

import com.ballad.security.entity.SysUser;
import com.ballad.security.service.SysUserService;
import com.ballad.statemachine.event.RegEventEnum;
import com.ballad.statemachine.state.RegStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;

public class OrderPersistStateChangeListener implements PersistStateMachineHandler.PersistStateChangeListener {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public void onPersist(State<RegStatusEnum, RegEventEnum> state,
                          Message<RegEventEnum> message,
                          Transition<RegStatusEnum, RegEventEnum> transition,
                          StateMachine<RegStatusEnum, RegEventEnum> stateMachine) {
        if (message != null && message.getHeaders().containsKey("order")) {
            Integer order = message.getHeaders().get("order", Integer.class);
            SysUser o = sysUserService.getById(order);
            RegStatusEnum status = state.getId();
            //TODO: 这个地方的status.toString究竟是什么还需要再研究
            o.setStatus(status.toString());
            sysUserService.saveOrUpdate(o);
        }
    }
}
