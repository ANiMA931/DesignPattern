package com.ballad;

import static org.junit.Assert.assertTrue;

import com.ballad.decorator.LoginSsoDecorator;
import com.ballad.decorator.interceptor.SsoInterceptor;
import com.ballad.observer.LotteryResult;
import com.ballad.observer.LotteryService;
import com.ballad.observer.LotteryServiceImpl;

import com.google.gson.Gson;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    Logger logger = LoggerFactory.getLogger(AppTest.class);

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    /**
     * 观察者模式测试类
     */
    @Test
    public void observerTest() {

        LotteryService lotteryService = new LotteryServiceImpl();
        String uuid = UUID.randomUUID().toString();
        LotteryResult result = lotteryService.draw(uuid);
        logger.info("测试结果：{}", new Gson().toJson(result));
    }

    /**
     * 装饰着模式测试类
     */
    @Test
    public void decoratorTest() {
        LoginSsoDecorator ssoDecorator = new LoginSsoDecorator(new SsoInterceptor());
        String request = "1successhuahua";
        boolean success = ssoDecorator.preHandle(request, "ewcdqwt40liuiu", "t");
        logger.info("登录校验：" + request + (success ? "放行" : "拦截"));
    }
}
