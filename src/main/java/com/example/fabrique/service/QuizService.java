package com.example.fabrique.service;

import com.example.fabrique.exception.QuizNotFoundException;
import com.example.fabrique.model.Quiz;

import java.util.List;

public interface QuizService {

    Quiz create(Quiz quiz);

    Quiz update(Quiz quiz);

    void delete(Long id);

    Quiz getById(Long id) throws QuizNotFoundException;

    List<Quiz> getAll();

}



