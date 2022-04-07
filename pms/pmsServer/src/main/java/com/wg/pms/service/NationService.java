package com.wg.pms.service;

import com.wg.pms.entity.Nation;

import java.util.List;

/**
 * 民族Service
 */
public interface NationService {
    /**
     * 获取所有民族信息
     * @return
     */
    List<Nation> getAllNations();

}
