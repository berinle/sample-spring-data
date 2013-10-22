package com.myapp;

import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;

/**
 * @author berinle
 */
@Configuration
@EnableMongoRepositories
public class AppConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.myapp");
        SessionRepository repository = ctx.getBean(SessionRepository.class);
        repository.findAll();
    }

    @Bean
    public Mongo mongo() throws UnknownHostException {
        return new Mongo("localhost");
    }

    @Bean
    public MongoTemplate mongoTemplate(Mongo mongo){
        return new MongoTemplate(mongo, "sample");
    }

}
