package com.myapp;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author berinle
 */
public interface CourseRepository extends MongoRepository<Course, String> {
}
