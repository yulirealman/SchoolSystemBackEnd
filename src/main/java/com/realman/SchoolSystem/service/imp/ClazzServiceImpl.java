package com.realman.SchoolSystem.service.imp;

import com.realman.SchoolSystem.exception.ClassHasStudentsException;
import com.realman.SchoolSystem.mapper.ClazzMapper;
import com.realman.SchoolSystem.mapper.StudentMapper;
import com.realman.SchoolSystem.pojo.*;
import com.realman.SchoolSystem.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private StudentMapper studentMapper;

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

    @Override
    public Clazz getInfo(Integer id) {
       return clazzMapper.getClazzById( id);
    }

    @Override
    public void save(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
    }

    @Override
    public void update(Clazz clazz) {
        clazzMapper.update(clazz);
    }



    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void deleteById(Integer id) {
        // we need to search class to see if
        // is there any student in this class
        // we can only delete class if there is no student in this class
        Long numOfStudent = studentMapper.countStudentByClazzId(id);
        if (numOfStudent > 0) {
            throw new ClassHasStudentsException("对不起, 该班级下有学生, 不能直接删除");
        }
        clazzMapper.deleteById(id);
    }
}
