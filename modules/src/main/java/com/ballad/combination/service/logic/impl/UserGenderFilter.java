package com.ballad.combination.service.logic.impl;

import com.ballad.combination.service.logic.BaseLogic;

import java.util.Map;

/**
 * @author Administrator
 * @Classname UserGenderFilter
 * @date 2023-06-30 18:04
 * @comment
 */
public class UserGenderFilter extends BaseLogic {
    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("gender");
    }
}
