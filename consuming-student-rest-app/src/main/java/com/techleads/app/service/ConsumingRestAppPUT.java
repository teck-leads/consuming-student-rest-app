package com.techleads.app.service;

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
public class ConsumingRestAppPUT implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("welcome");
		

		String url = "http://localhost:8082/students";
		RestTemplate restTemplate = new RestTemplate();

		ParameterizedTypeReference<Student> studentPTR = new ParameterizedTypeReference<Student>() {
		};

		System.out.println("=========put Request=========");
		HttpHeaders headers = new HttpHeaders();
		headers.set("client-1", "123");

		Student st = new Student();
		st.setId(8);
		st.setCourse("SpringBoot");
		st.setName("Nisha");
		st.setFees(1300D);

		HttpEntity<Student> httpEntity = new HttpEntity<>(st, headers);

		ResponseEntity<Student> exchnage = restTemplate.exchange(url, HttpMethod.PUT, httpEntity, studentPTR);

		
		Student body = exchnage.getBody();
		System.out.println(body);
		
		
		System.exit(0);//stop server
		
	}

}
