package com.milind.encryption.controllers;

import com.milind.encryption.entity.FilesEntity;
import com.milind.encryption.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/dataencryption")
public class DataController {

    @Autowired
    private FileService fileService;

    @PostMapping(value = "/encrypt", consumes = "multipart/form-data")
    public ResponseEntity<String> encrypt(@RequestParam("file") MultipartFile file) throws IOException {
        FilesEntity fileResponse = fileService.createFile(file);
        return ResponseEntity.status(201).body(fileResponse.toString());
    }
}
