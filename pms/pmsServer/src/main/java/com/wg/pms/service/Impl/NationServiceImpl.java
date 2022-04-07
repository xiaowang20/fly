package com.wg.pms.service.Impl;

import com.wg.pms.entity.Nation;
import com.wg.pms.mapper.NationMapper;
import com.wg.pms.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationServiceImpl implements NationService {
    @Autowired
    NationMapper nationMapper;
    @Override
    public List<Nation> getAllNations() {
        return nationMapper.getAllNations();
    }
}
