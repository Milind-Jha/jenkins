package com.milind.encryption.controllers;

import com.milind.encryption.dao.MongodbDao;
import com.milind.encryption.entity.FilesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/dataencryption")
public class DataController {

    @Autowired
    MongodbDao mongodbDao;

    @PostMapping("/encrypt")
    public ResponseEntity<String> encrypt(@RequestBody MultipartFile file){
        FilesEntity filesEntity = new FilesEntity(UUID.randomUUID().toString(),file);
        mongodbDao.save(filesEntity);
        return ResponseEntity.status(201).body("File Persisted");
    }
}
