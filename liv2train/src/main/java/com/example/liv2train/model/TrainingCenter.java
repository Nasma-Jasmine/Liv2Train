package com.example.liv2train.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;

@Document(collection = "trainingCenters")  // For MongoDB collections
public class TrainingCenter {

    @Id
    private String id;

    @NotNull
    private String centerName;

    @NotNull
    private String centerCode;

    private long createdOn;  // To store epoch time in seconds

    // Other fields like address, capacity, etc.

    // Getters and setters for all fields
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    public long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(long createdOn) {
        this.createdOn = createdOn;
    }

    // Add other getters and setters as needed
}
