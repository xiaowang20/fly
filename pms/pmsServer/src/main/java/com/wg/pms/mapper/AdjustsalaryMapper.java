package com.wg.pms.mapper;

import com.wg.pms.entity.Adjustsalary;
import com.wg.pms.entity.AdjustsalaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdjustsalaryMapper {
    long countByExample(AdjustsalaryExample example);

    int deleteByExample(AdjustsalaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Adjustsalary record);

    int insertSelective(Adjustsalary record);

    List<Adjustsalary> selectByExample(AdjustsalaryExample example);

    Adjustsalary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Adjustsalary record, @Param("example") AdjustsalaryExample example);

    int updateByExample(@Param("record") Adjustsalary record, @Param("example") AdjustsalaryExample example);

    int updateByPrimaryKeySelective(Adjustsalary record);

    int updateByPrimaryKey(Adjustsalary record);
}