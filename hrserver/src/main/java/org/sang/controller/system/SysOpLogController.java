package org.sang.controller.system;

import org.sang.bean.OpLog;
import org.sang.service.OpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/oplog")
public class SysOpLogController {
    @Autowired
    OpLogService opLogService;

    @GetMapping("/getLogs")
    public Map<String, Object> getOpLogs(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        List<OpLog> opLogs = opLogService.getOpLogs(page, size);
        Long count = opLogService.getOpLogCount();
        Map<String, Object> map = new HashMap<>();
        map.put("logs", opLogs);
        map.put("count", count);
        return map;
    }
}
