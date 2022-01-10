package com.example.fabrique.controller;

import com.example.fabrique.exception.QuizNotFoundException;
import com.example.fabrique.model.Quiz;
import com.example.fabrique.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Quiz quiz) {
        try {
            return ResponseEntity.ok(quizService.create(quiz));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Quiz quiz) {
        try {
            return ResponseEntity.ok(quizService.update(quiz));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @DeleteMapping()
    public ResponseEntity<?> delete(@RequestParam Long id) {
        try {
            quizService.delete(id);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @GetMapping("/byId")
    public ResponseEntity<?> getById(@RequestParam Long id) {
        try {
            Quiz byId = quizService.getById(id);
            return ResponseEntity.ok(byId);
        } catch (QuizNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(quizService.getAll());
    }
}
