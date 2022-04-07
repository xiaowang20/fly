package com.wg.pms.service;

import com.wg.pms.entity.MailSendLog;

/**
 * 设置消息服务
 */
public interface MailSendLogService {
    /**
     * 设置消息
     * @param mailSendLog
     * @return
     */
    int insert(MailSendLog mailSendLog);
}
