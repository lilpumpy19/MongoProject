package com.example.MongoProject.service;

import com.example.MongoProject.models.Line;
import com.example.MongoProject.repository.LineRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Line findById(String id) {
        Optional<Line> lineOptional = repository.findById(id);
        return lineOptional.orElse(null);
    }

    public void save(Line line) {
        repository.save(line);
    }

    public double getAverageSalary() {
        return repository.getAverageSalary();
    }

    public double getSumSalaryReport() {
        return repository.getSumSalaryReport();
    }

    public double getMaxSalaryReport() {
        return repository.getMaxSalaryReport();
    }
}
