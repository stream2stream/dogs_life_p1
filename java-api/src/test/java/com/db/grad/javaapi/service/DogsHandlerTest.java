package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DogsHandlerTest {
    private DogsRepository dogRepo = new DogsRepositoryStub();

    @BeforeEach
    public void make_sure_repo_is_empty(){
        dogRepo.deleteAll();
    }

    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one(){
        DogHandler dogHandler = new DogHandler(dogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        dogHandler.addDog( theDog );
        long actualResult = dogHandler.getNoOfDogs();
        int expectedResult = 1;
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void add_existing_dogs_return_number_of_dogs_in_repo_is_one(){
        DogHandler dogHandler = new DogHandler(dogRepo);
        Dog theDog = new Dog();
        theDog.setId(1);
        theDog.setName("Bruno");
        dogHandler.addDog( theDog );

        theDog.setId(1);
        theDog.setName("Bingo");
        dogHandler.addDog( theDog );

        long actualResult = dogHandler.getNoOfDogs();
        int expectedResult = 1;
        assertEquals(actualResult, expectedResult);
    }
}
