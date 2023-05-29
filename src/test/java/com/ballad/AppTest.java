package com.ballad;

import static org.junit.Assert.assertTrue;

import com.ballad.decorator.LoginSsoDecorator;
import com.ballad.decorator.interceptor.SsoInterceptor;
import com.ballad.factory.MyShape;
import com.ballad.factory.MyShapeFactory;
import com.ballad.observer.LotteryResult;
import com.ballad.observer.LotteryService;
import com.ballad.observer.LotteryServiceImpl;

import com.ballad.order.XiaoEr;
import com.ballad.order.cook.impl.GuangdongCook;
import com.ballad.order.cook.impl.JiangsuCook;
import com.ballad.order.cook.impl.ShandongCook;
import com.ballad.order.cuisine.ICuisine;
import com.ballad.order.cuisine.impl.GuangdongCuisine;
import com.ballad.order.cuisine.impl.JiangsuCuisine;
import com.ballad.order.cuisine.impl.ShandongCuisine;
import com.ballad.responsibilitychain.AuthLink;
import com.ballad.responsibilitychain.AuthService;
import com.ballad.responsibilitychain.impl.Level1AuthLink;
import com.ballad.responsibilitychain.impl.Level2AuthLink;
import com.ballad.responsibilitychain.impl.Level3AuthLink;
import com.ballad.utils.ToolUtil;
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
     * 装饰者模式测试方法
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
        logger.info("测试结果：{}", authLink.doAuth(ToolUtil.getUUID(), "1000998004813441", new Date()).toString());
        logger.info("----------------------------------------------");
        // 模拟三级负责人审批
        AuthService.auth("1000013", "1000998004813441");
        logger.info("{}", "模拟第一级负责人审批，王工");
        logger.info("测试结果：{}", authLink.doAuth(ToolUtil.getUUID(), "1000998004813441", new Date()));
        logger.info("----------------------------------------------");
        // 模拟二级负责人审批
        AuthService.auth("1000012", "1000998004813441");
        logger.info("{}", "模拟第二级负责人审批，张经理");
        logger.info("测试结果：{}", authLink.doAuth(ToolUtil.getUUID(), "1000998004813441", new Date()));
        logger.info("----------------------------------------------");
        // 模拟一级负责人审批
        AuthService.auth("1000011", "1000998004813441");
        logger.info("{}", "模拟第三级负责人审批，段总");
        logger.info("测试结果：{}", authLink.doAuth(ToolUtil.getUUID(), "1000998004813441", new Date()));
    }

    /**
     * 命令模式测试方法
     */
    @Test
    public void orderTest() {
        ICuisine guangdongCuisine = new GuangdongCuisine(new GuangdongCook());
        JiangsuCuisine jiangsuCuisine = new JiangsuCuisine(new JiangsuCook());
        ShandongCuisine shandongCuisine = new ShandongCuisine(new ShandongCook());
        XiaoEr xiaoEr = new XiaoEr();
        xiaoEr.order(guangdongCuisine);
        xiaoEr.order(jiangsuCuisine);
        xiaoEr.order(shandongCuisine);

        //下单
        xiaoEr.placeOrder();
        JiangsuCuisine jiangsuCuisine2 = new JiangsuCuisine(new GuangdongCook());
        xiaoEr.order(jiangsuCuisine2);
        logger.info("----------------------------------");
        xiaoEr.placeOrder();
    }

    /**
     * 工厂模式测试方法
     */
    @Test
    public void factoryTest(){
        MyShapeFactory shapeFactory = new MyShapeFactory();

        //获取 Circle 的对象，并调用它的 draw 方法
        MyShape shape1 = shapeFactory.getShape("CIRCLE");

        //调用 Circle 的 draw 方法
        shape1.draw();

        //获取 Rectangle 的对象，并调用它的 draw 方法
        MyShape shape2 = shapeFactory.getShape("RECTANGLE");

        //调用 Rectangle 的 draw 方法
        shape2.draw();

        //获取 Square 的对象，并调用它的 draw 方法
        MyShape shape3 = shapeFactory.getShape("SQUARE");

        //调用 Square 的 draw 方法
        shape3.draw();
    }
}
