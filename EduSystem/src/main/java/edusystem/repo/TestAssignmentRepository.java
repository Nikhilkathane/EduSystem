package edusystem.repo;

import edusystem.model.Exam;
import edusystem.model.Student;
import edusystem.model.TestAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface TestAssignmentRepository extends JpaRepository<TestAssignment, Long> {

    List<TestAssignment> findByStudent(Student student);

    List<TestAssignment> findByExam(Exam exam);

}
