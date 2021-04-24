package engine.controllers;

import engine.Answer;
import engine.Quiz;
import engine.QuizNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import engine.Solving;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.*;

@RestController
@RequestMapping("/api")
@Validated
public class QuizController {
    private final ArrayList<Quiz> quizzes = new ArrayList<>();
    private int id = 1;

    @PostMapping(value = "/quizzes", consumes = "application/json")
    public Quiz createQuiz(@Valid @RequestBody Quiz quiz) {
        quiz.setId(id);
        id++;
        quizzes.add(quiz);
        return quiz;
    }
    @GetMapping("/quizzes/{id}")
    public Quiz getQuiz(@PathVariable int id) throws QuizNotFoundException {
        Quiz resultQuiz = null;
        for(int i = 0;i < quizzes.size();i++) {
            if(quizzes.get(i).getId() == id) resultQuiz = quizzes.get(i);
        }
        if(resultQuiz == null) throw new QuizNotFoundException();
        return resultQuiz;
    }
    @GetMapping("/quizzes")
    public ArrayList<Quiz> getQuizzes() {
        return quizzes;
    }
    @PostMapping("/quizzes/{id}/solve")
    public Solving solveQuiz(@Min(0) @PathVariable int id, @RequestBody Answer answer) throws QuizNotFoundException {
        boolean success = false;
        Quiz quiz = getQuiz(id);
        String feedback = "Wrong answer! Please, try again.";
        if(isRightAnswer(quiz, answer)) {
            success = true;
            feedback = "Congratulations, you're right!";
        }
        return new Solving(success, feedback);
    }
    private boolean isRightAnswer(Quiz quiz, Answer answers) {
        List<Integer> quizAnswers = convertArrayToList(quiz.getAnswer());
        List<Integer> givenAnswers = answers.getAnswer();
        int matches = intersection(convertListToArray(quizAnswers),
                convertListToArray(givenAnswers)).length;
        return (matches == answers.getAmountOfAnswers());
    }
    public static int[] intersection(int[] a, int[] b) {
        return Arrays.stream(a)
                .distinct()
                .filter(x -> Arrays.stream(b).anyMatch(y -> y == x))
                .toArray();
    }
    private List<Integer> convertArrayToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < arr.length;i++) {
            list.add(arr[i]);
        }
        return list;
    }
    private int[] convertListToArray(List<Integer> list) {
        int[] resultArray = new int[list.size()];
        for(int i = 0;i < list.size();i++) {
            resultArray[i] = list.get(i);
        }
        return resultArray;
    }
}
