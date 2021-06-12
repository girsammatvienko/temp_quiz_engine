package engine.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class Quiz {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    private String title;

    @NotBlank
    private String text;

    @Size(min = 2)
    @NotNull
    private String[] options;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int[] answer;

    public Quiz() {

    }

    public Quiz(String title, String text, String[] options) {
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = new int[0];
    }

    public Quiz(String title, String text, String[] options, int[] answer) {
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setId(int id) { this.id = id; }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) { this.options = options; }
    @JsonIgnore
    public int[] getAnswer() { return answer; }
    @JsonProperty
    public void setAnswer(int[] answer) { this.answer = answer; }

    public int getId() { return id; }

}
