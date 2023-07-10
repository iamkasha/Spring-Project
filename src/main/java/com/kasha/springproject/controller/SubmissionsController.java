package com.kasha.springproject.controller;

import com.kasha.springproject.model.SubmissionsDTO;
import com.kasha.springproject.service.SubmissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submissions")
public class SubmissionsController {

    @Autowired
    private SubmissionsService submissionService;

    @GetMapping
    public ResponseEntity<List<SubmissionsDTO>> getAllSubmissions() {
        List<SubmissionsDTO> submissions = submissionService.getAllSubmissions();
        return new ResponseEntity<>(submissions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubmissionsDTO> getSubmissionById(@PathVariable int id) {
        SubmissionsDTO submission = submissionService.getSubmissionById(id);
        if (submission != null) {
            return new ResponseEntity<>(submission, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<SubmissionsDTO> createSubmission(@RequestBody SubmissionsDTO submission) {
        SubmissionsDTO createdSubmission = submissionService.createSubmission(submission);
        return new ResponseEntity<>(createdSubmission, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubmissionsDTO> updateSubmission(@PathVariable int id, @RequestBody SubmissionsDTO submission) {
        SubmissionsDTO updatedSubmission = submissionService.updateSubmission(id, submission);
        if (updatedSubmission != null) {
            return new ResponseEntity<>(updatedSubmission, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubmission(@PathVariable int id) {
        boolean deleted = submissionService.deleteSubmission(id);
        if (!deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
