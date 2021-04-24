package engine;

import java.util.ArrayList;
import java.util.List;

public class Answer {
    private List<Integer> answer;

    public Answer() {
    }

    public Answer(List<Integer> answer) {
        this.answer = answer;
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    public int getAmountOfAnswers() { return answer.size(); }
}
