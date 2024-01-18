import com.ballad.MyStateMachineApplication;
import com.ballad.statemachine.event.RegEventEnum;
import com.ballad.statemachine.service.SysUserStateService;
import com.ballad.statemachine.state.RegStatusEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;

@SpringBootTest(classes = MyStateMachineApplication.class)
public class MachineStateTest {

    @Autowired
    private StateMachine<RegStatusEnum, RegEventEnum> stateMachine;

    @Autowired
    private SysUserStateService sysUserStateService;
    @Test
    public void testStateMachine() {
        stateMachine.start();
        stateMachine.sendEvent(RegEventEnum.CONNECT);
        stateMachine.sendEvent(RegEventEnum.BEGIN_TO_LOGIN);
        stateMachine.sendEvent(RegEventEnum.LOGIN_SUCCESS);
        stateMachine.sendEvent(RegEventEnum.LOGOUT);
    }

    @Test
    public void testSysUserStateMachine() {
        System.out.println(sysUserStateService.listDbEntries());
    }
}
