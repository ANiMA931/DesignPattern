package com.ballad.combination.service.engine.impl;

import com.ballad.combination.model.aggregates.TreeRich;
import com.ballad.combination.model.vo.EngineResult;
import com.ballad.combination.model.vo.TreeNode;
import com.ballad.combination.service.engine.EngineBase;

import java.util.Map;

/**
 * @author Administrator
 * @Classname TreeEngineHandle
 * @date 2023-06-30 18:05
 * @comment
 */
public class TreeEngineHandle extends EngineBase {
    @Override
    public EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {
        // 决策流程
        TreeNode treeNode = engineDecisionMaker(treeRich, treeId, userId, decisionMatter);
        // 决策结果
        return new EngineResult(userId, treeId, treeNode.getTreeNodeId(), treeNode.getNodeValue());
    }
}
