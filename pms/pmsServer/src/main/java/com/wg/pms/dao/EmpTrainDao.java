package com.wg.pms.dao;

import com.wg.pms.entity.Employeetrain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 员工培训
 */
public interface EmpTrainDao {
    /**
     * 不为空
     * @param integer
     * @return
     */
    Employeetrain getList1(@Param("EID") Integer integer);

    List<Employeetrain> getList2(@Param("EID1") Integer integer);
}
