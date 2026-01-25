package com.milind.encryption.service;

import com.milind.encryption.entity.FilesEntity;
import com.milind.encryption.repo.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    public FilesEntity createFile(MultipartFile file) throws IOException {
        FilesEntity entity = new FilesEntity();
        entity.setFileId(UUID.randomUUID().toString());
        entity.setFileName(file.getOriginalFilename());
        entity.setFileType(file.getContentType());
        entity.setFileData(file.getBytes());
        return fileRepository.save(entity);
    }
}
