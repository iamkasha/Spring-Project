package com.kasha.springproject.service;

import com.kasha.springproject.model.SubmissionsDTO;
import com.kasha.springproject.repository.SubmissionRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionsService {

    @Autowired
    private SubmissionRepositoryImpl submissionsRepository;

    public List<SubmissionsDTO> getAllSubmissions() {
        return submissionsRepository.getAllSubmissions();
    }

    public SubmissionsDTO getSubmissionById(int id) {
        return submissionsRepository.getSubmissionById(id);
    }

    public SubmissionsDTO createSubmission(SubmissionsDTO submission) {
        return submissionsRepository.createSubmission(submission);
    }

    public SubmissionsDTO updateSubmission(int id, SubmissionsDTO updatedSubmission) {
        return submissionsRepository.updateSubmission(id, updatedSubmission);
    }

    public void deleteSubmission(int id) {
        submissionsRepository.deleteSubmission(id);
    }
}


