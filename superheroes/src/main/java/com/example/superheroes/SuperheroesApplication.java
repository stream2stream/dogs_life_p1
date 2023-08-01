package com.example.superheroes;

import com.example.superheroes.practice.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SuperheroesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SuperheroesApplication.class, args);
	}
	@Autowired
	Calculator calc;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World!");
		int result  = calc.addition(5,5);
		System.out.println(result);
	}
}
