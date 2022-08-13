package com.example.demo;

import com.example.demo.dao.StudentRepository;
import com.example.demo.model.Address;
import com.example.demo.model.Gender;
import com.example.demo.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repositorys, MongoTemplate template) {
		return args -> {
			Address address = new Address("Nakahate Wasti","Rahtani");
			Student student = new Student("Smitesh", "Shinde","smi@email.com", Gender.MALE,
					List.of("DBMS"), BigDecimal.TEN, LocalDateTime.now(), address);
			//repositorys.insert(student);
			//usingTemplateAndQuery(template);
			repositorys.findStudentByEmail("smit@email.com").ifPresentOrElse(student1 -> System.out.println("Record Found"),
					()-> System.out.println("No Record Found"));

		};

	}

	private void usingTemplateAndQuery(MongoTemplate template) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is("smi@email.com"));
		List<Student> students = template.find(query, Student.class);
		if(students.size() > 0) {
			System.out.println("Record Exists");
		}
	}

}
