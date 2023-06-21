package com.ballad.prototype;

import java.util.Map;

/**
 * @author Administrator
 * @Classname ChoiceQuestion
 * @date 2023-06-21 18:45
 * @comment
 */
public class ChoiceQuestion {
    /**
     * 题目
     */
    private String name;
    /**
     * 答案：ABCD
     */
    private Map<String, String> option;
    /**
     * 答案：B
     */
    private String key;

    public ChoiceQuestion(String name, Map<String, String> option, String
            key) {
        this.name = name;
        this.option = option;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
