package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    public void testGetDogById() {
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);
        // Dog 2 to fail the test
        Dog theDog2 = new Dog();
        theDog2.setName("Dog2");
        cut.addDog(theDog2);

        Dog expectedResult = theDog;
        Dog actualResult = cut.findById(1L);
        assertEquals(expectedResult, actualResult, "Sorry, could not find the dog");
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
    public void getDogByName(){
        DogHandler dogHandler = new DogHandler(itsDogRepo);
        //dog1
        Dog dog1 = new Dog();
        dog1.setName("Max");
        dogHandler.addDog(dog1);
        //dog2
        Dog dog2 = new Dog();
        dog2.setName("John");
        dogHandler.addDog(dog2);

        Dog dog3 = new Dog();
        dog3.setName("John");
        dogHandler.addDog(dog3);

        //Case 1: Dog with the given name exists
        Dog resultDog1 = dogHandler.getDogByName(dog1.getName());
        assertNotNull(resultDog1, "Dog should not be null");
        assertEquals(dog1.getName(), resultDog1.getName(), "Dog exists");

        //Case 2: Several Dogs exists with the same name - should return null
        Dog resultDog2 = dogHandler.getDogByName(dog2.getName());
        assertNull(resultDog2, "Dog should be null as there are several Dogs existing with the same name");
    }

    @Test
    public void checkIfDogIDIsUpdated(){
        DogHandler dogHandler = new DogHandler(itsDogRepo);

        Dog dog1 = new Dog();
        dog1.setId(56);

        assertEquals(56, dog1.getId());

        dog1.setId(1L);

        dogHandler.updateDogDetails(dog1);

        assertEquals(1L, dog1.getId());
    }

    @Test
    public void addAndRemoveDog(){
        DogHandler dogHandler = new DogHandler(itsDogRepo);

        Dog dog1 = new Dog();
        dog1.setName("Max");
        dogHandler.addDog( dog1 );

        Dog dog2 = new Dog();
        dog2.setName("Max2");
        dogHandler.addDog( dog2 );

        Dog dog3 = new Dog();
        dog3.setName("Max3");
        dogHandler.addDog( dog3 );

        dogHandler.removeDog(1);
        assertEquals(2, dogHandler.getNoOfDogs());

    }
}
