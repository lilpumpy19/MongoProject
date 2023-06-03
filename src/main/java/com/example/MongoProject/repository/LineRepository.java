package com.example.MongoProject.repository;

import com.example.MongoProject.models.Line;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineRepository extends MongoRepository<Line,String> {

}
