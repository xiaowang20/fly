package com.wg.pms.mapper;

import com.wg.pms.entity.Employeeec;
import com.wg.pms.entity.EmployeeecExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeecMapper {
    long countByExample(EmployeeecExample example);

    int deleteByExample(EmployeeecExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Employeeec record);

    int insertSelective(Employeeec record);

    List<Employeeec> selectByExample(EmployeeecExample example);

    Employeeec selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Employeeec record, @Param("example") EmployeeecExample example);

    int updateByExample(@Param("record") Employeeec record, @Param("example") EmployeeecExample example);

    int updateByPrimaryKeySelective(Employeeec record);

    int updateByPrimaryKey(Employeeec record);
}