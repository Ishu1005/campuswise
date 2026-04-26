package com.smartcampus.repository.Auth;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.smartcampus.model.Auth.MongoUserDocument;

public interface MongoUserRepository extends MongoRepository<MongoUserDocument, String> {
    Optional<MongoUserDocument> findBySqlUserId(Long sqlUserId);

    Optional<MongoUserDocument> findByEmail(String email);

    void deleteBySqlUserId(Long sqlUserId);
}
