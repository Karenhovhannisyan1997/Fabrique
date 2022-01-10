package com.example.fabrique.service.impl;

import com.example.fabrique.exception.QuizNotFoundException;
import com.example.fabrique.model.Quiz;
import com.example.fabrique.repository.QuizRepository;
import com.example.fabrique.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    @Override
    public Quiz create(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz update(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public void delete(Long id) {
        quizRepository.deleteById(id);
    }

    @Override
    public Quiz getById(Long id) throws QuizNotFoundException {
        Optional<Quiz> byId = quizRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            throw new QuizNotFoundException(String.format("Quiz by id %s not found", id));
        }
    }

    @Override
    public List<Quiz> getAll() {
        return quizRepository.findAll();
    }
}
