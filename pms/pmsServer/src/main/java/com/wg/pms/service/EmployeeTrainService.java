package com.wg.pms.service;

import com.wg.pms.entity.Employeetrain;

import java.util.List;

/**
 * 员工培训
 */
public interface EmployeeTrainService {
    /**
     * 条件分页查询员工培训信息
     * @param page
     * @param size
     * @param eId
     * @return
     */
    List<Employeetrain> list(Integer page, Integer size, Integer eId);

    /**
     * 添加员工培训信息
     * @param employeetrain
     * @return
     */
    int add(Employeetrain employeetrain);

    /**
     * 根据id修改员工培训信息
     * @param employeetrain
     * @return
     */
    int update(Employeetrain employeetrain);

    /**
     * 根据id删除员工培训信息
     * @param id
     * @return
     */
    int delete(Integer id);
}
