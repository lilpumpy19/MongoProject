package com.example.MongoProject.models;

import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document("MongoProject")
@Data
public class Line {
    @Id
    String id;
    @BsonProperty(value = "name")
    @Indexed(unique = true)
    String name;

    @BsonProperty(value = "date")
    Date date;

    @BsonProperty(value = "salary")
    int salary;


    public Line() {

    }

    public Line(String name,int salary) {
        this.id= UUID.randomUUID().toString();
        this.name = name;
        this.date=new Date();
        this.salary=salary;
    }



}
