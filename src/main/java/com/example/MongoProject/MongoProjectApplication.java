package com.example.MongoProject;

import com.example.MongoProject.models.Line;
import com.example.MongoProject.repository.LineRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.util.Date;

@SpringBootApplication
public class MongoProjectApplication {

	public static void main(String[] args) {
				SpringApplication.run(MongoProjectApplication.class, args);
	}
//	@Bean
//CommandLineRunner runner(LineRepository repository){
//		return args -> {
//			Line line = new Line("Jimmy",new Date());
//			repository.insert(line);
//		};
//
//}
}
