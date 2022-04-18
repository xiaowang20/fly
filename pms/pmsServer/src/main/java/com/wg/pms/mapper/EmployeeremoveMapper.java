package com.wg.pms.mapper;

import com.wg.pms.entity.Employeeremove;
import com.wg.pms.entity.EmployeeremoveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeremoveMapper {
    long countByExample(EmployeeremoveExample example);

    int deleteByExample(EmployeeremoveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Employeeremove record);

    int insertSelective(Employeeremove record);

    List<Employeeremove> selectByExample(EmployeeremoveExample example);

    Employeeremove selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Employeeremove record, @Param("example") EmployeeremoveExample example);

    int updateByExample(@Param("record") Employeeremove record, @Param("example") EmployeeremoveExample example);

    int updateByPrimaryKeySelective(Employeeremove record);

    int updateByPrimaryKey(Employeeremove record);

    /**
     * 通过名字获取id
     * @param keyword
     * @return
     */
    List<Integer> getIdNyName(String keyword);
}