package com.ballad.bridging.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Administrator
 * @Classname PayFaceMode
 * @date 2023-06-29 19:24
 * @comment
 */
public class PayFaceMode implements IPayMode {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean security(String uId) {
        logger.info("人脸支付，风险校验指纹信息");
        return true;
    }
}
