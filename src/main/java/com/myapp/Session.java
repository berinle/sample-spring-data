package com.myapp;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author berinle
 */
@Document
public class Session {

    private String id;
    private int capacity;
    private int available;

    @DBRef
    private Course course;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Session{");
        sb.append("id='").append(id).append('\'');
        sb.append(", capacity=").append(capacity);
        sb.append(", available=").append(available);
        sb.append(", course=").append(course);
        sb.append('}');
        return sb.toString();
    }
}
