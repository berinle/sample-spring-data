package com.myapp;

import com.mongodb.Mongo;
import com.mongodb.WriteConcern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

/**
 * @author berinle
 */
@Configuration
@ComponentScan("com.myapp")
@EnableMongoRepositories
public class AppConfig extends AbstractMongoConfiguration {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.myapp");
        SessionRepository repository = ctx.getBean(SessionRepository.class);
        CourseRepository courseRepository = ctx.getBean(CourseRepository.class);

        List<Session> sessions = repository.findAll();
        for (Session session : sessions) {
            System.out.println("session = " + session);
            System.out.println("session.getCourse().getName() = " + session.getCourse().getName());
            Course course = courseRepository.findOne(session.getCourse().getId());
            System.out.println("course.getName() = " + course.getName());
        }
    }

    @Autowired
    private List<Converter<?, ?>> converters;

    @Override
    protected String getDatabaseName() {
        return "sample";
    }

    @Override
    public Mongo mongo() throws Exception {
        Mongo mongo = new Mongo();
        mongo.setWriteConcern(WriteConcern.SAFE);
        return mongo;
    }

    @Override
    public CustomConversions customConversions() {
        return new CustomConversions(converters);
    }

}
