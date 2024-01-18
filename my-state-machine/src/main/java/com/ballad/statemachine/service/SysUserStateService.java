package com.ballad.statemachine.service;

import com.ballad.security.entity.SysUser;
import com.ballad.security.service.SysUserService;
import com.ballad.statemachine.event.RegEventEnum;
import com.ballad.statemachine.handler.SysUserPersistStateMachineHandler;
import com.ballad.statemachine.state.RegStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;

import java.util.List;
import java.util.StringJoiner;

public class SysUserStateService {

    private final SysUserPersistStateMachineHandler handler;


    public SysUserStateService(SysUserPersistStateMachineHandler handler) {
        this.handler = handler;
    }

    @Autowired
    private SysUserService repo;


    public String listDbEntries() {
        List<SysUser> sysUserList = repo.list();
        StringJoiner sj = new StringJoiner(",");
        for (SysUser order : sysUserList) {
            sj.add(order.toString());
        }
        return sj.toString();
    }


    public boolean change(int order, RegEventEnum event) {
        SysUser o = repo.getById(order);
        return handler.handleEventWithState(
                MessageBuilder.withPayload(event).setHeader("sysUser", order).build(),
                RegStatusEnum.valueOf(o.getStatus())
        );
    }

}
