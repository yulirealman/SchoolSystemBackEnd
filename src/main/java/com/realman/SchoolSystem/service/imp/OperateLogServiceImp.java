package com.realman.SchoolSystem.service.imp;

import com.realman.SchoolSystem.mapper.OperateLogMapper;
import com.realman.SchoolSystem.pojo.OperateLog;
import com.realman.SchoolSystem.pojo.PageResult;
import com.realman.SchoolSystem.service.OperateLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperateLogServiceImp implements OperateLogService {
    @Autowired private OperateLogMapper operateLogMapper;

    @Override
    public PageResult<OperateLog> page(Integer page, Integer pageSize) {

        Integer offset = (page - 1) * pageSize;

        List<OperateLog> rows = operateLogMapper.list(offset, pageSize);
        Long total = operateLogMapper.count();
        return new PageResult<OperateLog>(total, rows);

    }
}
