package edusystem.controller;

import edusystem.model.TestAssignment;
import edusystem.service.TestAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test-assignments")
public class TestAssignmentController {
    @Autowired
    private TestAssignmentService testAssignmentService;

    @GetMapping
    public List<TestAssignment> getAllTestAssignments() {
        return testAssignmentService.getAllTestAssignments();
    }

    @GetMapping("/{id}")
    public TestAssignment getTestAssignmentById(@PathVariable Long id) {
        return testAssignmentService.getTestAssignmentById(id);
    }

    @PostMapping
    public TestAssignment createTestAssignment(@RequestBody TestAssignment testAssignment) {
        return testAssignmentService.createTestAssignment(testAssignment);
    }

    @PutMapping("/{id}")
    public TestAssignment updateTestAssignment(@PathVariable Long id, @RequestBody TestAssignment testAssignment) {
        return testAssignmentService.updateTestAssignment(id, testAssignment);
    }

    @DeleteMapping("/{id}")
    public void deleteTestAssignment(@PathVariable Long id) {
        testAssignmentService.deleteTestAssignment(id);
    }
}

