package com.ballad;

import static org.junit.Assert.assertTrue;

import com.ballad.abstractfactory.factory.JDKProxy;
import com.ballad.abstractfactory.factory.impl.EGMCacheAdapter;
import com.ballad.abstractfactory.factory.impl.IIRCacheAdapter;
import com.ballad.abstractfactory.service.CacheService;
import com.ballad.abstractfactory.service.impl.CacheServiceImpl;
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
import java.util.concurrent.TimeUnit;

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
        //以上三条用于模拟初始化需要调用的命令与具体实现，一般是业务层面需要关注的东西；
        ICuisine guangdongCuisine = new GuangdongCuisine(new GuangdongCook());
        JiangsuCuisine jiangsuCuisine = new JiangsuCuisine(new JiangsuCook());
        ShandongCuisine shandongCuisine = new ShandongCuisine(new ShandongCook());
        XiaoEr xiaoEr = new XiaoEr();

        //对于命令执行者来说，只需要是一条命令即可，而命令即是实现了ICuisine接口的类对象
        // 具体的实现细节在调用这一步并不关键，不需要知晓细节；
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
    public void factoryTest() {
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

    /**
     * 抽象工厂模式测试方法
     * @throws Exception
     */
    @Test
    public void testCacheService() throws Exception {
        //获得某adapter适配到service的实例对象，在这种情况下，cacheService的具体对象已经变成了适配的对象了
        CacheService proxy_EGM = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapter());
        //而从本质讲，该对象是一个代理，本质是适配器调用的方法，但是是用代理的方法调用，顾可以屏蔽被适配服务间的区别
        proxy_EGM.set("user_name_01","111", 100000L , TimeUnit.HOURS);
        String val01 = proxy_EGM.get("user_name_01");
        System.out.println(val01);
        proxy_EGM.del("user_name_01");
        String val11 = proxy_EGM.get("user_name_01");
        System.out.println(val11);
        CacheService proxy_IIR = JDKProxy.getProxy(CacheServiceImpl.class, new IIRCacheAdapter());
        proxy_IIR.set("user_name_01","222");
        String val02 = proxy_IIR.get("user_name_01");
        System.out.println(val02);
    }
}
