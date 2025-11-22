package com.realman.SchoolSystem.service.imp;

import com.realman.SchoolSystem.mapper.ClazzMapper;
import com.realman.SchoolSystem.pojo.*;
import com.realman.SchoolSystem.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;


    @Override
    public PageResult<Clazz> page(ClazzQueryParam param) {
        Long total = clazzMapper.count(param);

        Integer offset = (param.getPage() - 1) * param.getPageSize();
        List<Clazz> rows = clazzMapper.list(param,offset);

        // based on the beginDate and endDate set status to (未开班，已开班，结课)
        for (Clazz clazz : rows) {
            if (clazz.getBeginDate() != null && clazz.getEndDate() != null) {
                if (clazz.getBeginDate().isAfter(LocalDate.now())) {
                    clazz.setStatus("未开班");
                } else if (clazz.getEndDate().isAfter(LocalDate.now())) {
                    clazz.setStatus("已开班");
                } else {
                    clazz.setStatus("结课");
                }
            }
        }


        return new PageResult<Clazz>(total,rows);
    }
}
