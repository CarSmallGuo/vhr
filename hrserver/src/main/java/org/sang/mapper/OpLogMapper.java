package org.sang.mapper;

import org.apache.ibatis.annotations.Param;
import org.sang.bean.OpLog;

import java.util.List;

public interface OpLogMapper {
    int addOpLog(@Param("log") OpLog log);

    List<OpLog> getOpLogs();
}
