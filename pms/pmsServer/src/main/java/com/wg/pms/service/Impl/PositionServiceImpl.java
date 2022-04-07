package com.wg.pms.service.Impl;

import com.wg.pms.entity.Position;
import com.wg.pms.mapper.PositionMapper;
import com.wg.pms.service.PositionService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionMapper positionMapper;
    @Override
    public List<Position> getAllPositions() {
        return positionMapper.getAllPositions();
    }
}
