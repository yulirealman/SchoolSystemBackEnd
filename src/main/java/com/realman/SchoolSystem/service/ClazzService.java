package com.realman.SchoolSystem.service;

import com.realman.SchoolSystem.pojo.Clazz;
import com.realman.SchoolSystem.pojo.ClazzQueryParam;
import com.realman.SchoolSystem.pojo.PageResult;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ClazzService {


    PageResult<Clazz> page(ClazzQueryParam param);

    Clazz getInfo(Integer id);

    void save(Clazz clazz);

    void update(Clazz clazz);
}
