package com.realman.SchoolSystem.service.imp;

import com.realman.SchoolSystem.mapper.StudentMapper;
import com.realman.SchoolSystem.pojo.Emp;
import com.realman.SchoolSystem.pojo.PageResult;
import com.realman.SchoolSystem.pojo.Student;
import com.realman.SchoolSystem.pojo.StudentQueryParam;
import com.realman.SchoolSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Student> page(StudentQueryParam param) {
        Long total = studentMapper.count(param);

        Integer offset = (param.getPage() - 1) * param.getPageSize();
        List<Student> rows = studentMapper.list(param,offset);



        return new PageResult<Student>(total,rows);
    }

    @Override
    public void save(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insert(student);
    }

    @Override
    public Student getById(Integer id) {
        return studentMapper.getById(id);
    }
}
