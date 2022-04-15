package com.wg.pms.service;

import com.wg.pms.entity.Position;

import java.util.List;

/**
 * 住址Service
 */
public interface PositionService {
    /**
     * 获取所有住址信息
     * @return
     */
    List<Position> getAllPositions();

    /**
     * 添加职位
     * @param position
     * @return
     */
    int add(Position position);

    /**
     * 根据id修改职位
     * @param id
     * @param position
     * @return
     */
    int update(Integer id, Position position);

    /**
     * 根据id删除职位信息
     * @param id
     * @return
     */
    int delete(Integer id);
}
