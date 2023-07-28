package com.example.superheroes;

import com.example.superheroes.model.Hero;
import com.example.superheroes.practice.Calculator;
import com.example.superheroes.repository.HeroRepository;
import com.example.superheroes.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SuperheroesApplication { /*implements CommandLineRunner {*/
//	@Autowired
//	HeroService heroService;
//	HeroRepository heroRepository;
//	Calculator calc;

	public static void main(String[] args) {

		SpringApplication.run(SuperheroesApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception{
//		List<Hero> heroes1 = heroService.getAllHeroes();
//		List<Hero> heroes2 = heroService.getLast3HeroesByName();
//		List<Hero> heroes3 = heroService.getHeroesStartingWithLetter("B");
//		for(Hero hero: heroes1) System.out.println(hero);
//		System.out.println();
//		for(Hero hero: heroes2) System.out.println(hero);
//		System.out.println();
//		for(Hero hero: heroes3) System.out.println(hero);
//	}
//	public void run(String... args) throws Exception{
//		System.out.println("hello");
//		int result = calc.addition(3,4);
//		System.out.println(result);
//	}
}
