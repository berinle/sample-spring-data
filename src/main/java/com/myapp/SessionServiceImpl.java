package com.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author berinle
 */
@Service
public class SessionServiceImpl implements SessionService {
    @Autowired
    SessionRepository repository;

    @Override
    public List<Session> getSessions() {
        return repository.findAll();
    }
}
