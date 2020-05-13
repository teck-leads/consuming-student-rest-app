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
//@Component
public class ConsumingRestAppFindById implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("welcome");
		
		String url="http://localhost:8082/students/8";
		RestTemplate rt=new RestTemplate();
	//	ResponseEntity<Student> forEntity = rt.getForEntity(url, Student.class);
		
		
		HttpHeaders headers=new HttpHeaders();
		headers.set("client-1", "123");
		HttpEntity<?> httpEntity=new HttpEntity<>(headers);
		ResponseEntity<Student> exchange = rt.exchange(url, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<Student>(){});
		Object[] uriVariables= {6};
		
		//ResponseEntity<Student> exchange = rt.exchange(url, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<Student>(){}, uriVariables);
		
		//System.out.println(forEntity.getBody());
		System.out.println("======Using Exchange=========");
		Student student = exchange.getBody();
		System.out.println(student);
		System.out.println("===============");
		//System.out.println(forEntity.getStatusCode());
		//System.out.println(forEntity.getStatusCodeValue());
		//System.out.println(forEntity.getHeaders());
		
		
		System.exit(0);//stop server
		
	}

}
