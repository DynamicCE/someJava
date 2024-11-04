package com.erkan.someJava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SomeJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SomeJavaApplication.class, args);
	}

}
