package com.kasha.springproject.model;

import lombok.Data;

@Data
public class SubmissionsDTO {

    private int id;
    private String ConsultantName;
    private String submissionDate;
    private String leadName;
    private String vendorName;
    private String rate;
    private String salesPersonName;
    private String technology;


    public SubmissionsDTO(int id, String consultantName) {
        this.id = id;
        this.ConsultantName = consultantName;
    }

    public SubmissionsDTO(int id, String consultantName, String submissionDate, String leadName, String vendorName, String rate, String salesPersonName, String technology) {
        this.id = id;
        ConsultantName = consultantName;
        this.submissionDate = submissionDate;
        this.leadName = leadName;
        this.vendorName = vendorName;
        this.rate = rate;
        this.salesPersonName = salesPersonName;
        this.technology = technology;
    }

    public SubmissionsDTO() {

    }
}

