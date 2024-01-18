package com.ballad.statemachine.handler;

import com.ballad.statemachine.event.RegEventEnum;
import com.ballad.statemachine.state.RegStatusEnum;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.access.StateMachineAccess;
import org.springframework.statemachine.listener.AbstractCompositeListener;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.statemachine.support.LifecycleObjectSupport;
import org.springframework.statemachine.support.StateMachineInterceptorAdapter;
import org.springframework.statemachine.transition.Transition;
import org.springframework.util.Assert;

import java.util.Iterator;
import java.util.List;

public class SysUserPersistStateMachineHandler extends LifecycleObjectSupport {

    private final StateMachine<RegStatusEnum, RegEventEnum> stateMachine;
    private final PersistingStateChangeInterceptor interceptor = new PersistingStateChangeInterceptor();
    private final CompositePersistStateChangeListener stateChangeListener = new CompositePersistStateChangeListener();

    /**
     * 实例化一个新的持久化状态机Handler
     *
     * @param stateMachine 状态机实例
     */
    public SysUserPersistStateMachineHandler(StateMachine<RegStatusEnum, RegEventEnum> stateMachine) {
        Assert.notNull(stateMachine, "State machine must be set");
        this.stateMachine = stateMachine;
    }

    @Override
    protected void onInit() {
        stateMachine.getStateMachineAccessor().doWithAllRegions(function ->
                function.addStateMachineInterceptor(interceptor)
        );
    }


    /**
     * 处理entity的事件
     *
     * @param event
     * @param state
     * @return 如果事件被接受处理，返回true
     */
    public boolean handleEventWithState(Message<RegEventEnum> event, RegStatusEnum state) {
        stateMachine.stop();
        List<StateMachineAccess<RegStatusEnum, RegEventEnum>> withAllRegions =
                stateMachine.getStateMachineAccessor().withAllRegions();
        for (StateMachineAccess<RegStatusEnum, RegEventEnum> a : withAllRegions) {
            a.resetStateMachine(new DefaultStateMachineContext<>(state, null, null, null));
        }
        stateMachine.start();
        return stateMachine.sendEvent(event);
    }

    /**
     * 添加listener
     *
     * @param listener the listener
     */
    public void addPersistStateChangeListener(PersistStateChangeListener listener) {
        stateChangeListener.register(listener);
    }


    /**
     * 可以通过 addPersistStateChangeListener，增加当前Handler的PersistStateChangeListener。
     * 在状态变化的持久化触发时，会调用相应的实现了PersistStateChangeListener的Listener实例。
     */
    public interface PersistStateChangeListener {

        /**
         * 当状态被持久化，调用此方法
         *
         * @param state
         * @param message
         * @param transition
         * @param stateMachine 状态机实例
         */
        void onPersist(State<RegStatusEnum, RegEventEnum> state,
                       Message<RegEventEnum> message,
                       Transition<RegStatusEnum, RegEventEnum> transition,
                       StateMachine<RegStatusEnum, RegEventEnum> stateMachine);
    }


    private class PersistingStateChangeInterceptor extends
            StateMachineInterceptorAdapter<RegStatusEnum, RegEventEnum> {
        // 状态预处理的拦截器方法
        @Override
        public void preStateChange(State<RegStatusEnum, RegEventEnum> state,
                                   Message<RegEventEnum> message,
                                   Transition<RegStatusEnum, RegEventEnum> transition,
                                   StateMachine<RegStatusEnum, RegEventEnum> stateMachine) {
            stateChangeListener.onPersist(state, message, transition, stateMachine);
        }
    }

    private static class CompositePersistStateChangeListener extends
            AbstractCompositeListener<PersistStateChangeListener> implements
            PersistStateChangeListener {
        @Override
        public void onPersist(State<RegStatusEnum, RegEventEnum> state,
                              Message<RegEventEnum> message,
                              Transition<RegStatusEnum, RegEventEnum> transition,
                              StateMachine<RegStatusEnum, RegEventEnum> stateMachine) {
            for (Iterator<PersistStateChangeListener> iterator = getListeners().reverse(); iterator.hasNext(); ) {
                PersistStateChangeListener listener = iterator.next();
                listener.onPersist(state, message, transition, stateMachine);
            }
        }
    }

}
