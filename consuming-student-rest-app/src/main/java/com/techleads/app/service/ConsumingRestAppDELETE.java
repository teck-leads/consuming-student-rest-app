package com.techleads.app.service;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.techleads.app.model.Student;
@Component
public class ConsumingRestAppDELETE implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("welcome");
		
		String url = "http://localhost:8082/students/8";
		RestTemplate restTemplate = new RestTemplate();

		ParameterizedTypeReference<List<Student>> studentPTR = new ParameterizedTypeReference<List<Student>>(){};

		System.out.println("=========DELETE Request=========");
		HttpHeaders headers = new HttpHeaders();
		headers.set("client-1", "123");

		
		HttpEntity<Student> httpEntity = new HttpEntity<>(headers);

		ResponseEntity<List<Student>> exchnage = restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, studentPTR);

		
	 List<Student> Students = exchnage.getBody();
	 Students.stream()
	 .forEach(System.out::println);
		
		
		System.exit(0);//stop server
		
	}

}
