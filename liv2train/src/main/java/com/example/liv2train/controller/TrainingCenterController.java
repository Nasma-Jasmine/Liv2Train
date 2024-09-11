package com.example.liv2train.controller;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.liv2train.model.TrainingCenter;
import com.example.liv2train.repository.TrainingCenterRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {

    @Autowired
    private TrainingCenterRepository trainingCenterRepository;

    

    @PostMapping
    public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {
        // Set server time for createdOn
        trainingCenter.setCreatedOn(Instant.now().getEpochSecond());

        // Save the training center in MongoDB
        TrainingCenter savedTrainingCenter = trainingCenterRepository.save(trainingCenter);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedTrainingCenter);
    }

    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
        List<TrainingCenter> trainingCenters = trainingCenterRepository.findAll();
        return ResponseEntity.ok(trainingCenters);
    }
}
