package com.zfw.feign.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author hero良
 * @className FileController
 * @description
 * @date 2019/11/11 13:39
 */
@Slf4j
@RestController
public class FileController {

    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleFileUpload(@RequestPart(value = "file")MultipartFile file){
        return file.getName();
    }

    @GetMapping(value = "/testException")
    public String testException(String num){

        try {
            Integer integer = Integer.valueOf(num);
            return "";
        }catch (Exception e){
            log.error("123", e);
            return "";
        }
    }
}
