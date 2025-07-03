package com.springrest.service;

import com.springrest.model.Assignment;
import com.springrest.repository.AssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;

    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public Assignment save(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public List<Assignment> getAll() {
        return assignmentRepository.findAll();
    }
}
