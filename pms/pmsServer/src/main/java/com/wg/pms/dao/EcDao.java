package com.wg.pms.dao;

import com.wg.pms.entity.Employeeec;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 员工奖罚
 */
public interface EcDao {
    /**
     * 获取
     * @param eid
     * @return
     */
    List<Employeeec> getList(@Param("EID") Integer eid);
}
