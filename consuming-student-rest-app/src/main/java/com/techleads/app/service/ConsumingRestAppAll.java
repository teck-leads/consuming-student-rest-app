package com.techleads.app.service;

import java.util.Arrays;
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
//@Component
public class ConsumingRestAppAll implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("welcome");
		
		String url="http://localhost:8082/students";
		RestTemplate rt=new RestTemplate();
		
		ResponseEntity<Student[]> forEntity = rt.getForEntity(url, Student[].class);
		
		
		Student[] body = forEntity.getBody();
		List<Student> asList = Arrays.asList(body);
		asList.stream()
		.forEach(System.out::println);
		
		System.out.println("=========Using exchange=========");
		
		HttpHeaders headers=new HttpHeaders();
		headers.set("client-1", "123");
		
		HttpEntity<?> httpEntity=new HttpEntity<>(headers);
		
		ResponseEntity<List<Student>> exchnage = rt.exchange(url, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Student>>(){});
		
		List<Student> studentList = exchnage.getBody();
		
		studentList.stream()
		.forEach(System.out::println);
		
		System.out.println("==================");
		System.out.println(forEntity.getBody());
		System.out.println(forEntity.getStatusCode());
		System.out.println(forEntity.getStatusCodeValue());
		System.out.println(forEntity.getHeaders());
		
		
		System.exit(0);//stop server
		
	}

}
