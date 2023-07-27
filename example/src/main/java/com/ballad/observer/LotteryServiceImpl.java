package com.ballad.observer;

import java.util.Date;

/**
 * @author: 05697
 * @date: 2021/10/26
 * @comment:
 */
public class LotteryServiceImpl extends LotteryService{
    /**
     * 小型汽车摇号服务
     */
    private final MinibusTargetService minibusTargetService = new MinibusTargetService();

    @Override
    protected LotteryResult doDraw(String uId) {
        String lottery = minibusTargetService.lottery(uId);
        // 结果
        return new LotteryResult(uId, lottery, new Date());
    }
}
