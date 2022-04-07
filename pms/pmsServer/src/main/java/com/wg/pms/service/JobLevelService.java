package com.wg.pms.service;

import com.wg.pms.entity.Joblevel;
import com.wg.pms.entity.Position;

import java.util.List;

/**
 * 职业级别Service
 */
public interface JobLevelService {
    /**
     * 获取所有职业级别信息
     * @return
     */
    List<Joblevel> getAllJobLevels();

}
