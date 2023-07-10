package com.kasha.springproject.repository;
import com.kasha.springproject.model.SubmissionsDTO;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SubmissionRepositoryImpl {

    private List<SubmissionsDTO> submissions = new ArrayList<>();
    private int nextId = 1;

    public List<SubmissionsDTO> getAllSubmissions() {
        return submissions;
    }

    public SubmissionsDTO getSubmissionById(int id) {
        for (SubmissionsDTO submission : submissions) {
            if (submission.getId() == id) {
                return submission;
            }
        }
        return null;
    }

    public SubmissionsDTO createSubmission(SubmissionsDTO submission) {
        submission.setId(nextId++);
        submissions.add(submission);
        return submission;
    }

    public SubmissionsDTO updateSubmission(int id, SubmissionsDTO updatedSubmission) {
        for (SubmissionsDTO submission : submissions) {
            if (submission.getId() == id) {
                submission.setConsultantName(updatedSubmission.getConsultantName());
                submission.setSubmissionDate(updatedSubmission.getSubmissionDate());
                submission.setLeadName(updatedSubmission.getLeadName());
                submission.setVendorName(updatedSubmission.getVendorName());
                submission.setRate(updatedSubmission.getRate());
                submission.setSalesPersonName(updatedSubmission.getSalesPersonName());
                submission.setTechnology(updatedSubmission.getTechnology());
                return submission;
            }
        }
        return null; // Or throw an exception if the submission is not found
    }

    public int deleteSubmission(int id) {
        submissions.removeIf(submission -> submission.getId() == id);
        return id;
    }
}
