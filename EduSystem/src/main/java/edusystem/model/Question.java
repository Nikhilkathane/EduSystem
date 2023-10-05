package edusystem.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String questionText;
    private String correctAnswer;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;

    private boolean multipleCorrectAnswers; // true if multiple answers are allowed

    public Question() {
    }

    public Question(String questionText, String correctAnswer, String optionA, String optionB, String optionC, String optionD, boolean multipleCorrectAnswers) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.multipleCorrectAnswers = multipleCorrectAnswers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public boolean isMultipleCorrectAnswers() {
        return multipleCorrectAnswers;
    }

    public void setMultipleCorrectAnswers(boolean multipleCorrectAnswers) {
        this.multipleCorrectAnswers = multipleCorrectAnswers;
    }

    // Relationships
    @ManyToOne
    private Exam exam;

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionText='" + questionText + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", optionA='" + optionA + '\'' +
                ", optionB='" + optionB + '\'' +
                ", optionC='" + optionC + '\'' +
                ", optionD='" + optionD + '\'' +
                ", multipleCorrectAnswers=" + multipleCorrectAnswers +
                '}';
    }

    // hashCode() and equals() methods (based on 'id' field)
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Question question = (Question) obj;
        return Objects.equals(id, question.id);
    }
}

