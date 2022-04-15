package com.wg.pms.service.Impl;

import com.wg.pms.entity.Joblevel;
import com.wg.pms.entity.Position;
import com.wg.pms.mapper.JoblevelMapper;
import com.wg.pms.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobLevelServiceImpl implements JobLevelService {
    @Autowired
    JoblevelMapper joblevelMapper;
    @Override
    public List<Joblevel> getAllJobLevels() {
        return joblevelMapper.getJobLevelsAll();
    }

    @Override
    public int add(Joblevel joblevel) {

        return joblevelMapper.insert(joblevel);
    }

    @Override
    public int update(Integer id, Joblevel joblevel) {

        joblevel.setId(id);
        return joblevelMapper.updateByPrimaryKeySelective(joblevel);
    }

    @Override
    public int delete(Integer id) {

        return joblevelMapper.deleteByPrimaryKey(id);
    }
}
