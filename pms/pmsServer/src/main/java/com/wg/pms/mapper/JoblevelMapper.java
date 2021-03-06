package com.wg.pms.mapper;

import com.wg.pms.entity.Joblevel;
import com.wg.pms.entity.JoblevelExample;
import java.util.List;

import com.wg.pms.entity.Position;
import org.apache.ibatis.annotations.Param;

public interface JoblevelMapper {
    long countByExample(JoblevelExample example);

    int deleteByExample(JoblevelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Joblevel record);

    int insertSelective(Joblevel record);

    List<Joblevel> selectByExample(JoblevelExample example);

    Joblevel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Joblevel record, @Param("example") JoblevelExample example);

    int updateByExample(@Param("record") Joblevel record, @Param("example") JoblevelExample example);

    int updateByPrimaryKeySelective(Joblevel record);

    int updateByPrimaryKey(Joblevel record);

    List<Joblevel> getJobLevelsAll();
}