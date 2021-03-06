package com.wg.pms.service.Impl;

import com.wg.pms.controller.politicsStatus.PoliticsStatusController;
import com.wg.pms.entity.Politicsstatus;
import com.wg.pms.entity.PoliticsstatusExample;
import com.wg.pms.mapper.PoliticsstatusMapper;
import com.wg.pms.service.PoliticsStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliticsStatusServiceImpl implements PoliticsStatusService {
    @Autowired
    PoliticsstatusMapper politicsstatusMapper;

    @Override
    public List<Politicsstatus> list(Integer id) {
        PoliticsstatusExample example = new PoliticsstatusExample();
        example.createCriteria().andIdEqualTo(id);

        return politicsstatusMapper.selectByExample(example);
    }

    @Override
    public List<Politicsstatus> getAllPoliticsStatus() {
        return politicsstatusMapper.getAllPoliticsStatus();
    }

    @Override
    public int add(Politicsstatus politicsstatus) {

        return politicsstatusMapper.insert(politicsstatus);
    }

    @Override
    public int update(Integer id, Politicsstatus politicsstatus) {

        politicsstatus.setId(id);
        return politicsstatusMapper.updateByPrimaryKeySelective(politicsstatus);
    }

    @Override
    public int delete(Integer id) {

        return politicsstatusMapper.deleteByPrimaryKey(id);
    }
}
