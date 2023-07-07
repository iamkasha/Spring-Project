package com.kasha.springproject.controller;

import com.kasha.springproject.model.SubmissionsDTO;
import com.kasha.springproject.service.SubmissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submissions")
public class SubmissionsController {

    @Autowired
    private SubmissionsService submissionService;

    @GetMapping
    public List<SubmissionsDTO> getAllSubmissions() {
        return submissionService.getAllSubmissions();
    }

    @GetMapping("/{id}")
    public SubmissionsDTO getSubmissionById(@PathVariable int id) {
        return submissionService.getSubmissionById(id);
    }

    @PostMapping
    public SubmissionsDTO createSubmission(@RequestBody SubmissionsDTO submission) {
        return submissionService.createSubmission(submission);
    }

    @PutMapping("/{id}")
    public SubmissionsDTO updateSubmission(@PathVariable int id, @RequestBody SubmissionsDTO submission) {
        return submissionService.updateSubmission(id, submission);
    }

    @DeleteMapping("/{id}")
    public void deleteSubmission(@PathVariable int id) {
        submissionService.deleteSubmission(id);
    }
}


