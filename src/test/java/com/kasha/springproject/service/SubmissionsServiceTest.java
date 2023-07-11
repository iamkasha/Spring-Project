package com.kasha.springproject.service;

import com.kasha.springproject.model.SubmissionsDTO;
import com.kasha.springproject.repository.SubmissionRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SubmissionsServiceTest {

    @Mock
    private SubmissionRepositoryImpl submissionRepository;

    @InjectMocks
    private SubmissionsService submissionsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllSubmissions() {
        List<SubmissionsDTO> mockSubmissions = Arrays.asList(
                new SubmissionsDTO(1, "Submission 1"),
                new SubmissionsDTO(2, "Submission 2"),
                new SubmissionsDTO(3, "Submission 3")
        );

        when(submissionRepository.getAllSubmissions()).thenReturn(mockSubmissions);

        List<SubmissionsDTO> result = submissionsService.getAllSubmissions();

        assertEquals(mockSubmissions, result);
    }

    @Test
    public void testGetAllSubmissionsEmpty() {
        when(submissionRepository.getAllSubmissions()).thenReturn(Collections.emptyList());

        List<SubmissionsDTO> result = submissionsService.getAllSubmissions();

        assertTrue(result.isEmpty());
    }

    @Test
    public void testCreateSubmission() {
        SubmissionsDTO mockSubmission = new SubmissionsDTO(1, "New Submission");

        when(submissionRepository.createSubmission(any(SubmissionsDTO.class))).thenReturn(mockSubmission);

        SubmissionsDTO result = submissionsService.createSubmission(mockSubmission);

        assertEquals(mockSubmission, result);
    }

    @Test
    public void testCreateSubmissionNull() {
        when(submissionRepository.createSubmission(any(SubmissionsDTO.class))).thenReturn(null);

        SubmissionsDTO result = submissionsService.createSubmission(null);

        assertNull(result);
    }

    @Test
    public void testUpdateSubmission() {
        int submissionId = 1;
        SubmissionsDTO updatedSubmission = new SubmissionsDTO(submissionId, "Updated Submission");

        when(submissionRepository.updateSubmission(eq(submissionId), any(SubmissionsDTO.class))).thenReturn(updatedSubmission);

        SubmissionsDTO result = submissionsService.updateSubmission(submissionId, updatedSubmission);

        assertEquals(updatedSubmission, result);
    }

    @Test
    public void testUpdateSubmissionNotFound() {

        int submissionId = 1;
        SubmissionsDTO updatedSubmission = new SubmissionsDTO(submissionId, "Updated Submission");

        when(submissionRepository.updateSubmission(eq(submissionId), any(SubmissionsDTO.class))).thenReturn(null);

        SubmissionsDTO result = submissionsService.updateSubmission(submissionId, updatedSubmission);

        assertNull(result);
    }

    @Test
    public void testDeleteSubmission() {

        int submissionId = 1;

        boolean result = submissionsService.deleteSubmission(submissionId);

        verify(submissionRepository).deleteSubmission(submissionId);

        assertFalse(result);
    }

}

