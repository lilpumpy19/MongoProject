package com.example.MongoProject.repository;

import com.example.MongoProject.models.Line;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineRepository extends MongoRepository<Line,String> {
    @Aggregation("{$group: {_id: null, averageSalary: {$avg: '$salary'}}}")
    double getAverageSalary();

    @Aggregation("{$group: {_id: null, totalSalary: {$sum: '$salary'}}}")
    double getSumSalaryReport();

    @Aggregation("{$group: {_id: null, maxSalary: {$max: '$salary'}}}")
    double getMaxSalaryReport();
}
