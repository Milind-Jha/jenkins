package com.milind.encryption.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class FilesEntity {

    @Id
    private String fileId;

    private String fileName;

    private String fileType;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] fileData;


    @Override
    public String toString() {
        return "{" +
                "file Id:" + fileId +
                ", file name:" + this.getFileName() +
                ", file type:" + this.getFileType()+
                '}';
    }
}
