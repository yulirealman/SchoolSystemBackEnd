package com.realman.SchoolSystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.realman.SchoolSystem.pojo.Result;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {

    @PostMapping
    public Result upload(String name, Integer age, MultipartFile file) throws IOException {
        log.info("Upload File Name: {}, Age: {}, File: {}", name, age,file);

        // this is to save at  local
//        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
//        String fileName = UUID.randomUUID().toString()+suffix;
//        file.transferTo(new File("C:/MyProgram/" + fileName));

        // in real project, we should save at cloud, such as aws s3
        //upload file and return url
        return Result.success("https://cdn-icons-png.flaticon.com/512/1144/1144760.png");
    }
}
