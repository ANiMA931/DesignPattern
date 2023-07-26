package com.ballad.combination.service.engine;

import com.ballad.combination.model.aggregates.TreeRich;
import com.ballad.combination.model.vo.EngineResult;

import java.util.Map;

/**
 * @author Administrator
 * @Classname IEngine
 * @date 2023-06-30 17:57
 * @comment
 */
public interface IEngine {

    EngineResult process(final Long treeId, final String userId, TreeRich treeRich, final Map<String, String> decisionMatter);

}
