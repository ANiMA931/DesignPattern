package com.ballad.bridging.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Administrator
 * @Classname PayFaceMode
 * @date 2023-06-29 19:24
 * @comment
 */
public class PayFingerprintMode implements IPayMode {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean security(String uId) {
        logger.info("指纹支付，风险校验脸部识别");
        return true;
    }
}
