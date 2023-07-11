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
        // Mock data
        List<SubmissionsDTO> mockSubmissions = Arrays.asList(
                new SubmissionsDTO(1, "Submission 1"),
                new SubmissionsDTO(2, "Submission 2"),
                new SubmissionsDTO(3, "Submission 3")
        );

        // Mock the repository behavior
        when(submissionRepository.getAllSubmissions()).thenReturn(mockSubmissions);

        // Call the service method
        List<SubmissionsDTO> result = submissionsService.getAllSubmissions();

        // Verify the result
        assertEquals(mockSubmissions, result);
    }

    @Test
    public void testGetAllSubmissionsEmpty() {
        // Mock the repository behavior to return an empty list
        when(submissionRepository.getAllSubmissions()).thenReturn(Collections.emptyList());

        // Call the service method
        List<SubmissionsDTO> result = submissionsService.getAllSubmissions();

        // Verify the result is an empty list
        assertTrue(result.isEmpty());
    }

    @Test
    public void testCreateSubmission() {
        // Mock data
        SubmissionsDTO mockSubmission = new SubmissionsDTO(1, "New Submission");

        // Mock the repository behavior
        when(submissionRepository.createSubmission(any(SubmissionsDTO.class))).thenReturn(mockSubmission);

        // Call the service method
        SubmissionsDTO result = submissionsService.createSubmission(mockSubmission);

        // Verify the result
        assertEquals(mockSubmission, result);
    }

    @Test
    public void testCreateSubmissionNull() {
        // Mock the repository behavior to return null when creating a submission
        when(submissionRepository.createSubmission(any(SubmissionsDTO.class))).thenReturn(null);

        // Call the service method
        SubmissionsDTO result = submissionsService.createSubmission(null);

        // Verify the result is null
        assertNull(result);
    }

    @Test
    public void testUpdateSubmission() {
        // Mock data
        int submissionId = 1;
        SubmissionsDTO updatedSubmission = new SubmissionsDTO(submissionId, "Updated Submission");

        // Mock the repository behavior
        when(submissionRepository.updateSubmission(eq(submissionId), any(SubmissionsDTO.class))).thenReturn(updatedSubmission);

        // Call the service method
        SubmissionsDTO result = submissionsService.updateSubmission(submissionId, updatedSubmission);

        // Verify the result
        assertEquals(updatedSubmission, result);
    }

    @Test
    public void testUpdateSubmissionNotFound() {
        // Mock data
        int submissionId = 1;
        SubmissionsDTO updatedSubmission = new SubmissionsDTO(submissionId, "Updated Submission");

        // Mock the repository behavior to return null when updating a non-existent submission
        when(submissionRepository.updateSubmission(eq(submissionId), any(SubmissionsDTO.class))).thenReturn(null);

        // Call the service method
        SubmissionsDTO result = submissionsService.updateSubmission(submissionId, updatedSubmission);

        // Verify the result is null
        assertNull(result);
    }

    @Test
    public void testDeleteSubmission() {
        // Mock data
        int submissionId = 1;

        // Call the service method
        boolean result = submissionsService.deleteSubmission(submissionId);

        // Verify that the repository method was called
        verify(submissionRepository).deleteSubmission(submissionId);

        // Verify the result is false (hard-coded in the original method)
        assertFalse(result);
    }

}

