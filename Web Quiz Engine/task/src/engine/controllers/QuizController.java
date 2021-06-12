package engine.controllers;

import engine.entity.Answer;
import engine.entity.Quiz;
import engine.entity.QuizNotFoundException;
import engine.service.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import engine.entity.Solving;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.*;

@RestController
@RequestMapping("/api")
@Validated
public class QuizController {
    private Service service;


    public QuizController() {
        this.service = new Service();
    }

    @PostMapping(value = "/quizzes", consumes = "application/json")
    public Quiz createQuiz(@Valid @RequestBody Quiz quiz) {
        service.addQuiz(quiz);
        return quiz;
    }

    @GetMapping("/quizzes/{id}")
    public Quiz getQuiz(@PathVariable int id) throws QuizNotFoundException {
        Quiz resultQuiz = null;
        for(int i = 0;i < service.getQuizzesAmount();i++) {
            if(service.getQuizById(i).getId() == id) resultQuiz = service.getQuizById(i);
        }
        if(resultQuiz == null) throw new QuizNotFoundException();
        return resultQuiz;
    }

    @GetMapping("/quizzes")
    public List<Quiz> getQuizzes() {
        return service.getAllQuizzes();
    }

    @PostMapping("/quizzes/{id}/solve")
    public Solving solveQuiz(@Min(0) @PathVariable int id, @RequestBody Answer answer) throws QuizNotFoundException {
        return service.solveQuiz(id, answer);
    }

}
