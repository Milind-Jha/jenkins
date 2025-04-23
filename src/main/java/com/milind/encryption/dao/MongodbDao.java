package com.milind.encryption.dao;

import com.milind.encryption.entity.FilesEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongodbDao extends MongoRepository<FilesEntity,String> {
}
