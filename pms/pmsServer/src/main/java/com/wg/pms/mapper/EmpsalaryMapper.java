package com.wg.pms.mapper;

import com.wg.pms.entity.Empsalary;
import com.wg.pms.entity.EmpsalaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmpsalaryMapper {
    long countByExample(EmpsalaryExample example);

    int deleteByExample(EmpsalaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Empsalary record);

    int insertSelective(Empsalary record);

    List<Empsalary> selectByExample(EmpsalaryExample example);

    Empsalary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Empsalary record, @Param("example") EmpsalaryExample example);

    int updateByExample(@Param("record") Empsalary record, @Param("example") EmpsalaryExample example);

    int updateByPrimaryKeySelective(Empsalary record);

    int updateByPrimaryKey(Empsalary record);
}