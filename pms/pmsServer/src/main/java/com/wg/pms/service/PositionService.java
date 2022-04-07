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

}
