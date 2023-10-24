package com.example.MongoProject.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document("MongoProject")
@Data
@Schema(description = "Line that shows the person's salary data")
public class Line {
    @Id
    @Schema(
            description = "Unique identifier",
            example = "1234",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    String id;

    @BsonProperty(value = "name")
    @Indexed(unique = true)
    @Schema(description = "Person's name")
    String name;

    @BsonProperty(value = "date")
    @Schema(description = "Date of payment",accessMode = Schema.AccessMode.READ_ONLY)
    Date date;

    @BsonProperty(value = "salary")
    @Schema(description = "Person's salary")
    int salary;


    public Line() {

    }

    public Line(String name, int salary) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.date = new Date();
        this.salary = salary;
    }


}
