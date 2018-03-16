package org.sang.controller.system;

import org.sang.bean.OpLog;
import org.sang.service.OpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/oplog")
public class SysOpLogController {
    @Autowired
    OpLogService opLogService;

    @GetMapping("/getLogs")
    public List<OpLog> getOpLogs() {
        List<OpLog> opLogs = opLogService.getOpLogs();
        return opLogs;
    }
}
