package com.ballad.prototype.util;

import java.util.Map;

/**
 * @author Administrator
 * @Classname Topic
 * @date 2023-06-21 18:58
 * @comment
 */
public class Topic {
    private Map<String, String> option;
    private String key;

    public Topic(Map<String, String> option, String key) {
        this.option = option;
        this.key = key;
    }

    public Map<String, String> getOption() {
        return option;
    }

    public void setOption(Map<String, String> option) {
        this.option = option;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
