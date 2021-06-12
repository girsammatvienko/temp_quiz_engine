package engine.repository;

import engine.entity.Quiz;
import engine.entity.QuizNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class QuizRepository {
    private final ArrayList<Quiz> quizzes = new ArrayList<>();


    public void save(Quiz quiz) {

        quizzes.add(quiz);
    }

    public List<Quiz> getAll() {
        return quizzes;
    }

    public int getSize() { return quizzes.size(); }

    public Quiz getElementById(int id) throws QuizNotFoundException {
        if(!exists(id)) throw new QuizNotFoundException();
        return quizzes.get(id);
    }

    private boolean exists(int id) {
        for(Quiz quiz:quizzes) {
            if(quiz.getId() == id) return true;
        }
        return false;
    }
}
