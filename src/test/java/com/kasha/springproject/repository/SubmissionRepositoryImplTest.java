package com.kasha.springproject.repository;

import com.kasha.springproject.model.SubmissionsDTO;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SubmissionRepositoryImplTest {

    @Test
    public void testGetAllSubmissions() {
        SubmissionRepositoryImpl submissionRepository = new SubmissionRepositoryImpl();

        SubmissionsDTO submission1 = new SubmissionsDTO(1, "Sachin");
        SubmissionsDTO submission2 = new SubmissionsDTO(2, "Virat");
        SubmissionsDTO submission3 = new SubmissionsDTO(3, "MS Dhoni");

        submissionRepository.createSubmission(submission1);
        submissionRepository.createSubmission(submission2);
        submissionRepository.createSubmission(submission3);

        List<SubmissionsDTO> result = submissionRepository.getAllSubmissions();

        assertEquals(3, result.size());
        assertEquals(submission1, result.get(0));
        assertEquals(submission2, result.get(1));
        assertEquals(submission3, result.get(2));
    }

    @Test
    public void testGetAllSubmissionsEmpty() {
        SubmissionRepositoryImpl submissionRepository = new SubmissionRepositoryImpl();
        List<SubmissionsDTO> result = submissionRepository.getAllSubmissions();
        assertEquals(0, result.size());
    }

        @Test
        public void testGetSubmissionById() {
            SubmissionRepositoryImpl submissionRepository = new SubmissionRepositoryImpl();
            SubmissionsDTO mockSubmission = new SubmissionsDTO(1, "Sachin");
            submissionRepository.createSubmission(mockSubmission);

            SubmissionsDTO result = submissionRepository.getSubmissionById(1);
            assertEquals(mockSubmission, result);
        }

        @Test
        public void testGetSubmissionByIdNotFound() {
            SubmissionRepositoryImpl submissionRepository = new SubmissionRepositoryImpl();
            SubmissionsDTO result = submissionRepository.getSubmissionById(1);
            assertNull(result);
        }


        @Test
        public void testCreateSubmission() {
            SubmissionRepositoryImpl submissionRepository = new SubmissionRepositoryImpl();
            SubmissionsDTO mockSubmission = new SubmissionsDTO(1, "Sachin");
            SubmissionsDTO result = submissionRepository.createSubmission(mockSubmission);
            assertNotNull(result);
            assertEquals(mockSubmission, result);
        }

        @Test
        public void testCreateSubmissionAutoGeneratedId() {
            SubmissionRepositoryImpl submissionRepository = new SubmissionRepositoryImpl();
            SubmissionsDTO mockSubmission = new SubmissionsDTO();
            mockSubmission.setConsultantName("Sachin");

            SubmissionsDTO result = submissionRepository.createSubmission(mockSubmission);

            assertNotNull(result);
            assertEquals(1, result.getId());
            assertEquals(mockSubmission.getConsultantName(), result.getConsultantName());
        }

        @Test
        public void testUpdateSubmission() {
            SubmissionRepositoryImpl submissionRepository = new SubmissionRepositoryImpl();

            SubmissionsDTO mockSubmission = new SubmissionsDTO(1, "Sachin");
            submissionRepository.createSubmission(mockSubmission);

            SubmissionsDTO updatedSubmission = new SubmissionsDTO(1, "Dravid");

            SubmissionsDTO result = submissionRepository.updateSubmission(1, updatedSubmission);

            assertNotNull(result);
            assertEquals(updatedSubmission, result);
            assertEquals("Dravid", result.getConsultantName());
        }

        @Test
        public void testUpdateSubmissionNotFound() {
            SubmissionRepositoryImpl submissionRepository = new SubmissionRepositoryImpl();

            SubmissionsDTO updatedSubmission = new SubmissionsDTO(1, "Dravid");

            SubmissionsDTO result = submissionRepository.updateSubmission(1, updatedSubmission);

            assertNull(result);
        }


        @Test
        public void testDeleteSubmission() {

            SubmissionRepositoryImpl submissionRepository = new SubmissionRepositoryImpl();

            SubmissionsDTO mockSubmission = new SubmissionsDTO(1, "Sachin");
            submissionRepository.createSubmission(mockSubmission);

            int result = submissionRepository.deleteSubmission(1);

            assertEquals(1, result);
            assertTrue(submissionRepository.getAllSubmissions().isEmpty());
        }

        @Test
        public void testDeleteSubmissionNotFound() {
            SubmissionRepositoryImpl submissionRepository = new SubmissionRepositoryImpl();

            int result = submissionRepository.deleteSubmission(1);

            assertEquals(1, result);
        }
}

