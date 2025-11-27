package com.realman.SchoolSystem.service;

import com.realman.SchoolSystem.pojo.OperateLog;
import com.realman.SchoolSystem.pojo.PageResult;

public interface OperateLogService {
    PageResult<OperateLog> page(Integer page, Integer pageSize);
}
