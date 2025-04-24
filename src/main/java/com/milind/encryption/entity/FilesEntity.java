package com.milind.encryption.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FilesEntity {

    String fileId;
    MultipartFile multipartFile;

    @Override
    public String toString() {
        return "{" +
                "file Id:" + fileId +
                ", file name:" + multipartFile.getName() +
                ", file size:" + multipartFile.getSize()+
                '}';
    }
}
