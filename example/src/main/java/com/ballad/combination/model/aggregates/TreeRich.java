package com.ballad.combination.model.aggregates;

import com.ballad.combination.model.vo.TreeNode;
import com.ballad.combination.model.vo.TreeRoot;

import java.util.Map;

/**
 * @author Administrator
 * @Classname Treerich
 * @date 2023-06-30 17:49
 * @comment
 */
public class TreeRich {

    /**
     * 树根信息
     */
    private TreeRoot treeRoot;
    /**
     * 树节点ID -> 子节点
     */
    private Map<Long, TreeNode> treeNodeMap;

    public TreeRich(TreeRoot treeRoot, Map<Long, TreeNode> treeNodeMap) {
        this.treeRoot = treeRoot;
        this.treeNodeMap = treeNodeMap;
    }

    public TreeRoot getTreeRoot() {
        return treeRoot;
    }

    public void setTreeRoot(TreeRoot treeRoot) {
        this.treeRoot = treeRoot;
    }

    public Map<Long, TreeNode> getTreeNodeMap() {
        return treeNodeMap;
    }

    public void setTreeNodeMap(Map<Long, TreeNode> treeNodeMap) {
        this.treeNodeMap = treeNodeMap;
    }
}
