package org.sang.service;


import org.sang.bean.OpLog;
import org.sang.mapper.OpLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpLogService {
    @Autowired
    OpLogMapper opLogMapper;

    public List<OpLog> getOpLogs(Integer page, Integer size) {
        int start = (page - 1) * size;
        return opLogMapper.getOpLogs(start, size);
    }

    public Long getOpLogCount() {
        return opLogMapper.getOpLogCount();
    }
}
