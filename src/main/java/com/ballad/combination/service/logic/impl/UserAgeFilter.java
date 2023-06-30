package com.ballad.combination.service.logic.impl;

import com.ballad.combination.service.logic.BaseLogic;

import java.util.Map;

/**
 * @author Administrator
 * @Classname UserAgeFilter
 * @date 2023-06-30 18:02
 * @comment
 */
public class UserAgeFilter extends BaseLogic {
    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("age");
    }
}
