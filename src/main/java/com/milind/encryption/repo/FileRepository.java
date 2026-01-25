package com.milind.encryption.repo;

import com.milind.encryption.entity.FilesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FilesEntity,String> {
}
