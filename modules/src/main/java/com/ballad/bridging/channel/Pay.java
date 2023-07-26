package com.ballad.bridging.channel;

import com.ballad.bridging.mode.IPayMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * @author Administrator
 * @Classname Pay
 * @date 2023-06-29 19:15
 * @comment
 */
public abstract class Pay {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    protected IPayMode payMode;
    public Pay(IPayMode payMode) {
        this.payMode = payMode;
    }
    public abstract String transfer(String uId, String tradeId, BigDecimal
            amount);
}
