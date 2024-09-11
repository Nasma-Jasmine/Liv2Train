package com.example.liv2train.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.liv2train.model.TrainingCenter;

public interface TrainingCenterRepository extends MongoRepository<TrainingCenter, String> {
}
