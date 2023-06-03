package com.example.MongoProject.models;

import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document("MongoProject")
@Data
public class Line {
    @Id
    String id;
    @BsonProperty(value = "name")
    String name;

    @BsonProperty(value = "date")
    Date date;

    @BsonProperty(value = "salary")
    int salary;


    public Line() {

    }

    public Line(String name,Date date,int salary) {
        this.id= UUID.randomUUID().toString();
        this.name = name;
        this.date=date;
        this.salary=salary;
    }



}
