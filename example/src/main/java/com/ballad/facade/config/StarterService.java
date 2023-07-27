package com.ballad.facade.config;

/**
 * @author Administrator
 * @Classname StarterService
 * @date 2023-07-04 10:56
 * @comment
 */
public class StarterService {
    private String userStr;
    public StarterService(String userStr) {
        this.userStr = userStr;
    }
    public String[] split(String separatorChar) {
        return this.userStr.split(separatorChar);
    }
}
