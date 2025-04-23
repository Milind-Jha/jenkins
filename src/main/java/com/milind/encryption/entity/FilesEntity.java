package com.milind.encryption.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Id;

@Document(collection = "files")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class FilesEntity {

    @Id
    String fileId;
    MultipartFile multipartFile;
}
