package com.wg.pms.dao;

import com.wg.pms.entity.Employeeremove;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 员工调动
 */
public interface EmpRemoveDao {
    /**
     * integer不为空时，获取数据
     * @param eid
     * @return
     */
    Employeeremove getList1(@Param("EID") Integer eid);

    List<Employeeremove> getList2(@Param("EID1") Integer eid1);
}
