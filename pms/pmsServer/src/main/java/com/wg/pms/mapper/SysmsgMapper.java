package com.wg.pms.mapper;

import com.wg.pms.entity.Sysmsg;
import com.wg.pms.entity.SysmsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysmsgMapper {
    long countByExample(SysmsgExample example);

    int deleteByExample(SysmsgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sysmsg record);

    int insertSelective(Sysmsg record);

    List<Sysmsg> selectByExample(SysmsgExample example);

    Sysmsg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sysmsg record, @Param("example") SysmsgExample example);

    int updateByExample(@Param("record") Sysmsg record, @Param("example") SysmsgExample example);

    int updateByPrimaryKeySelective(Sysmsg record);

    int updateByPrimaryKey(Sysmsg record);
}