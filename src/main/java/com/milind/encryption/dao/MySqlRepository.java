package com.milind.encryption.dao;

import com.milind.encryption.entity.EncryptedDataDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MySqlRepository extends JpaRepository<EncryptedDataDetails, String> {
}

