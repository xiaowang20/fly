package com.wg.pms.dao;

import com.wg.pms.entity.Adjustsalary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 员工调薪
 */
public interface AdjustSalaryDao {
    /**
     * 不为空
     * @param integer
     * @return
     */
    Adjustsalary getList1(@Param("EID") Integer integer);

    List<Adjustsalary> getList2(@Param("EID1") Integer integer);
}
