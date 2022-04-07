package com.wg.pms.service.Impl;

import com.wg.pms.entity.MailSendLog;
import com.wg.pms.mapper.MailSendLogMapper;
import com.wg.pms.service.MailSendLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailSendLogServiceImpl implements MailSendLogService {
    @Autowired
    MailSendLogMapper mailSendLogMapper;
    @Override
    public int insert(MailSendLog mailSendLog) {
        return mailSendLogMapper.insert(mailSendLog);
    }
}
