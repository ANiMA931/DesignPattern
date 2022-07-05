package com.ballad;

import static org.junit.Assert.assertTrue;

import com.alibaba.fastjson.JSON;
import com.ballad.decorator.LoginSsoDecorator;
import com.ballad.decorator.interceptor.SsoInterceptor;
import com.ballad.observer.LotteryResult;
import com.ballad.observer.LotteryService;
import com.ballad.observer.LotteryServiceImpl;

import com.ballad.responsibilitychain.AuthLink;
import com.ballad.responsibilitychain.AuthService;
import com.ballad.responsibilitychain.impl.Level1AuthLink;
import com.ballad.responsibilitychain.impl.Level2AuthLink;
import com.ballad.responsibilitychain.impl.Level3AuthLink;
import com.google.gson.Gson;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Date;
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
     * 观察者模式测试方法
     */
    @Test
    public void observerTest() {

        LotteryService lotteryService = new LotteryServiceImpl();
        String uuid = UUID.randomUUID().toString();
        LotteryResult result = lotteryService.draw(uuid);
        logger.info("测试结果：{}", new Gson().toJson(result));
    }

    /**
     * 装饰着模式测试方法
     */
    @Test
    public void decoratorTest() {
        LoginSsoDecorator ssoDecorator = new LoginSsoDecorator(new SsoInterceptor());
        String request = "1successhuahua";
        boolean success = ssoDecorator.preHandle(request, "ewcdqwt40liuiu", "t");
        logger.info("登录校验：" + request + (success ? "放行" : "拦截"));
    }

    /**
     * 责任链模式测试方法
     */
    @Test
    public void responsibilityChainTest() throws ParseException {
        AuthLink authLink = new Level3AuthLink("1000013", "王工")
                .appendNext(new Level2AuthLink("1000012", "张经理")
                        .appendNext(new Level1AuthLink("1000011", "段总")));
        logger.info("测试结果{}", JSON.toJSONString(authLink.doAuth("王小堃",
                "1000998004813441", new Date())));
        // 模拟三级负责人审批
        AuthService.auth("1000013", "1000998004813441");
        logger.info("�����{}", "������������");
        logger.info("�����{}", JSON.toJSONString(authLink.doAuth("���",
                "1000998004813441", new Date())));
        // 模拟二级负责人审批
        AuthService.auth("1000012", "1000998004813441");
        logger.info("�����{}", "�������������");
        logger.info("�����{}", JSON.toJSONString(authLink.doAuth("���",
                "1000998004813441", new Date())));
        // 模拟一级负责人审批
        AuthService.auth("1000011", "1000998004813441");
        logger.info("�����{}", "������������");
        logger.info("�����{}", JSON.toJSONString(authLink.doAuth("���",
                "1000998004813441", new Date())));
    }
}
