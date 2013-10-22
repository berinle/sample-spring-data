package com.myapp;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author berinle
 */
@Document
public class Course {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Component
    static class CourseToStringConverter implements Converter<Course, String> {

        @Override
        public String convert(Course source) {
            return source == null? null: source.id;
        }
    }

    @Component
    static class StringToCourseConverter implements Converter<String, Course> {

        @Override
        public Course convert(String source) {
            if(StringUtils.hasText(source)){
                Course course = new Course();
                course.setId(source);
                return course;
            } else {
                return null;
            }
        }
    }
}
