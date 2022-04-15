package com.wg.pms.service;

import com.wg.pms.controller.politicsStatus.PoliticsStatusController;
import com.wg.pms.entity.Politicsstatus;

import java.util.List;

public interface PoliticsStatusService {
    /**
     * 根据id获取政治面貌信息
     * @param id
     * @return
     */
   List<Politicsstatus> list(Integer id);

    /**
     * 获取所有政治面貌
     * @return
     */
    List<Politicsstatus> getAllPoliticsStatus();

    /**
     * 添加政治面貌
     * @param politicsstatus
     * @return
     */
    int add(Politicsstatus politicsstatus);

    /**
     * 根据id修改政治面貌
     * @param id
     * @param politicsstatus
     * @return
     */
    int update(Integer id, Politicsstatus politicsstatus);

    /**
     * 根据id删除政治面貌信息
     * @param id
     * @return
     */
    int delete(Integer id);
}
