package com.ballad.facade.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Administrator
 * @Classname StarterServiceProperties
 * @date 2023-07-04 19:45
 * @comment
 */
@ConfigurationProperties("itstack.door")
public class StarterServiceProperties {
    private String userStr;
    private Boolean enabled;

    public String getUserStr() {
        return userStr;
    }

    public void setUserStr(String userStr) {
        this.userStr = userStr;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
