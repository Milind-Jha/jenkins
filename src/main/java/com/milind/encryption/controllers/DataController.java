package com.milind.encryption.controllers;

import com.milind.encryption.entity.FilesEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/dataencryption")
public class DataController {
    @PostMapping(value = "/encrypt", consumes = "multipart/form-data")
    public ResponseEntity<String> encrypt(@RequestParam("file") MultipartFile file) {
        FilesEntity filesEntity = new FilesEntity(UUID.randomUUID().toString(), file);
        return ResponseEntity.status(201).body(filesEntity.toString());
    }
    @GetMapping(value = "/check")
    public ResponseEntity<String> check() {
        return ResponseEntity.status(201).body("hello kubernetes");
    }
}
