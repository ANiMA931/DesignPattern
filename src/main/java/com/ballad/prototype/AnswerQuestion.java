package com.ballad.prototype;

/**
 * @author Administrator
 * @Classname AnswerQuestion
 * @date 2023-06-21 18:48
 * @comment
 */
public class AnswerQuestion {

    /**
     * 问题
     */
    private String name;
    /**
     * 答案
     */
    private String key;

    public AnswerQuestion(String name, String key) {
        this.name = name;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
