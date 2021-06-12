package engine.service;

import engine.entity.Answer;
import engine.entity.Quiz;
import engine.entity.QuizNotFoundException;
import engine.entity.Solving;
import engine.repository.QuizRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Service {
    private QuizRepository repository;
    private int id = 0;
    public Service() {
        this.repository = new QuizRepository();
    }

    public void addQuiz(Quiz quiz) {
        quiz.setId(id);
        repository.save(quiz);
        id++;
    }

    public List<Quiz> getAllQuizzes() {
        return repository.getAll();
    }

    public Solving solveQuiz(int id, Answer answer) throws QuizNotFoundException {
        boolean success = false;
        Quiz quiz = repository.getElementById(id);
        int[] rightAnswers = convertListToArray(quiz.getAnswer());
        int[] userAnswers = convertListToArray(answer.getAnswer());
        Arrays.sort(rightAnswers);
        Arrays.sort(userAnswers);
        System.out.print("User answers: ");
        String feedback = "Wrong answer! Please, try again.";

        if(isEqual(rightAnswers, userAnswers)) {
            success = true;
            feedback = "Congratulations, you're right!";
        }
        System.out.println(success + "|" + feedback);
        return new Solving(success, feedback);
    }


    private static boolean isEqual(int[] arr1, int[] arr2) {
        if(arr1.length != arr2.length) {
            return false;
        }
        for(int i = 0;i < arr1.length;i++) {
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
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
        System.out.println("asd:" +resultArray.length);
        return resultArray;
    }

    public int getQuizzesAmount() { return repository.getSize(); }

    public Quiz getQuizById(int id) throws QuizNotFoundException { return repository.getElementById(id); }
}
