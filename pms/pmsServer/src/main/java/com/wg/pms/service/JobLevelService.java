package com.wg.pms.service;

import com.wg.pms.entity.Department;
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

    /**
     * 添加职称
     * @param joblevel
     * @return
     */
    int add(Joblevel joblevel);

    /**
     * 根据id修改职称
     * @param id
     * @param joblevel
     * @return
     */
    int update(Integer id, Joblevel joblevel);

    /**
     * 根据id删除职称信息
     * @param id
     * @return
     */
    int delete(Integer id);
}
