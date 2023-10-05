package edusystem.service;


import edusystem.model.TestAssignment;
import edusystem.repo.TestAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TestAssignmentService {

    @Autowired
    private TestAssignmentRepository testAssignmentRepository;

    public List<TestAssignment> getAllTestAssignments() {
        return testAssignmentRepository.findAll();
    }

    public TestAssignment getTestAssignmentById(Long id) {
        return testAssignmentRepository.findById(id).orElse(null);
    }

    public TestAssignment createTestAssignment(TestAssignment testAssignment) {
        return testAssignmentRepository.save(testAssignment);
    }

    public TestAssignment updateTestAssignment(Long id, TestAssignment testAssignment) {
        testAssignment.setId(id);
        return testAssignmentRepository.save(testAssignment);
    }

    public void deleteTestAssignment(Long id) {
        testAssignmentRepository.deleteById(id);
    }
}


