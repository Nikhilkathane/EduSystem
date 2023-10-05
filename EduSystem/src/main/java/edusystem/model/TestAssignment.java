package edusystem.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class TestAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean completed;
    private int score;

    public TestAssignment() {
    }

    public TestAssignment(boolean completed, int score) {
        this.completed = completed;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // Relationships
    @ManyToOne
    private Student student;

    @ManyToOne
    private Exam exam;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    @Override
    public String toString() {
        return "TestAssignment{" +
                "id=" + id +
                ", completed=" + completed +
                ", score=" + score +
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
        TestAssignment testAssignment = (TestAssignment) obj;
        return Objects.equals(id, testAssignment.id);
    }
}

