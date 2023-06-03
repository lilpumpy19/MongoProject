package com.example.MongoProject.service;

import com.example.MongoProject.models.Line;
import com.example.MongoProject.repository.LineRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LineService {
    private final LineRepository repository;

    public List<Line> getLines(){
        return repository.findAll();
    }
    public void deleteLineById(String id){
        repository.deleteById(id);
    }

    public void addLine(Line line){
        repository.save(line);
    }
}
