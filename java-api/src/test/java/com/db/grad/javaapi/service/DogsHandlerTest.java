package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DogsHandlerTest {

    private DogsRepository itsDogRepo = new DogsRepositoryStub();

    @BeforeEach
    public void makeSureRepoIsEmpty() {
        itsDogRepo.deleteAll();
    }

    @Test
    public void addADogReturnNumberOfDogsInRepoIsOne(){

        //arrange

        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );

        int expectedResult = 1;

        // act

        long actualResult = cut.getNoOfDogs();

        // assert

        assertEquals( expectedResult, actualResult );
    }

    @Test
    public void addSeveralDogsReturnNumberOfDogsMatchNumberAdded(){
        DogHandler dogHandler = new DogHandler(itsDogRepo);

        Dog dog1 = new Dog();
        dog1.setName("Max");
        dogHandler.addDog( dog1 );

        Dog dog2 = new Dog();
        dog2.setName("John");
        dogHandler.addDog( dog2 );

        Dog dog3 = new Dog();
        dog3.setName("Wick");
        dogHandler.addDog( dog3 );

        assertEquals(3, dogHandler.getNoOfDogs(), "Number of dogs does not match the number added");
    }

    @Test
    public void checkIfDogIDIsUpdated(){
        DogHandler dogHandler = new DogHandler(itsDogRepo);

        Dog dog1 = new Dog();
        dog1.setId(483729L);

        Dog dog2 = new Dog();
        dog2.setId(99999L);

        dogHandler.addDog(dog1);
        dogHandler.addDog(dog2);

        assertEquals(dog1.getId(), dogHandler.updateDogDetails(dog1), "The IDs of the dogs do not match.");
    }

}
