package com.myapp;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author berinle
 */
public interface SessionRepository extends MongoRepository<Session, String> {
}
