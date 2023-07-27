package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DogsHandlerTest {

    private DogsRepository dogsRepository = new DogsRepositoryStub();

    @BeforeEach
    public void makeSureRepoIsEmpty() {
        dogsRepository.deleteAll();
    }

    @Test
    @DisplayName("add one dog in repository and test size")
    public void addDogReturnNumberOfDogsInRepoIsOne() {
        //arrange
        DogHandler dogHandler = new DogHandler(dogsRepository);
        Dog dog = new Dog();
        dog.setName("Bruno");
        dogHandler.addDog(dog);

        int expectedResult = 1;

        //act
        long actualResult = dogHandler.getNoOfDogs();

        //assert
        assertEquals(expectedResult, actualResult);

    }
}
