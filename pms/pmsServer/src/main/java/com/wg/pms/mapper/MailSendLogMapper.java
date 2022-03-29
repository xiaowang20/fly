package com.wg.pms.mapper;

import com.wg.pms.entity.MailSendLog;
import com.wg.pms.entity.MailSendLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MailSendLogMapper {
    long countByExample(MailSendLogExample example);

    int deleteByExample(MailSendLogExample example);

    int insert(MailSendLog record);

    int insertSelective(MailSendLog record);

    List<MailSendLog> selectByExample(MailSendLogExample example);

    int updateByExampleSelective(@Param("record") MailSendLog record, @Param("example") MailSendLogExample example);

    int updateByExample(@Param("record") MailSendLog record, @Param("example") MailSendLogExample example);
}