package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class DogsHandlerTest {
    private DogsRepository dogRepo = new DogsRepositoryStub();

    @BeforeEach
    public void make_sure_repo_is_empty() {
        dogRepo.deleteAll();
    }

    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one() {
        DogHandler dogHandler = new DogHandler(dogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        dogHandler.addDog(theDog);
        long actualResult = dogHandler.getNoOfDogs();
        int expectedResult = 1;
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void add_existing_dogs_return_number_of_dogs_in_repo_is_one() {
        DogHandler dogHandler = new DogHandler(dogRepo);
        Dog theDog = new Dog();
        theDog.setId(1);
        theDog.setName("Bruno");
        dogHandler.addDog(theDog);

        theDog.setId(1);
        theDog.setName("Bingo");
        dogHandler.addDog(theDog);

        long actualResult = dogHandler.getNoOfDogs();
        int expectedResult = 1;
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void check_if_existing_dog_returns_not_null() {
        DogHandler dogHandler = new DogHandler(dogRepo);
        Dog theDog = new Dog();
        theDog.setId(1);
        theDog.setName("Bruno");
        dogHandler.addDog(theDog);

        Dog actualResult = dogHandler.getDogById(1);
        assertNotNull(actualResult);

    }

    @Test
    public void check_if_not_existing_dog_returns_null() {
        DogHandler dogHandler = new DogHandler(dogRepo);
        Dog theDog = new Dog();
        theDog.setId(1);
        theDog.setName("Bruno");
        dogHandler.addDog(theDog);

        Dog actualResult = dogHandler.getDogById(2);
        assertNull(actualResult);

    }


    public void getDogByName_ShouldReturnNullIfDogDoesNotExist() {
        DogHandler dogHandler = new DogHandler(dogRepo);

        // Search for a dog with a name that doesn't exist in the repository
        Dog result = dogHandler.getDogByName("Rex");
        Assertions.assertNull(result, "Should return null if the dog does not exist");
    }

    @Test
    public void getDogByName_ShouldReturnNullIfMultipleDogsExistWithSameName() {
        DogHandler dogHandler = new DogHandler(dogRepo);
        Dog theDog1 = new Dog();
        theDog1.setId(1);
        theDog1.setName("Buddy");
        dogHandler.addDog(theDog1);

        Dog theDog2 = new Dog();
        theDog2.setId(2);
        theDog2.setName("Buddy");
        dogHandler.addDog(theDog2);

        // Search for a dog with a name that has multiple occurrences in the repository
        Dog result = dogHandler.getDogByName("Buddy");
        Assertions.assertNull(result, "Should return null if multiple dogs exist with the same name");
    }

    @Test
    public void getDogByName_ShouldReturnSingleDogObjectIfUniqueName() {
        DogHandler dogHandler = new DogHandler(dogRepo);
        Dog theDog1 = new Dog();
        theDog1.setId(1);
        theDog1.setName("Buddy");
        dogHandler.addDog(theDog1);

        Dog theDog2 = new Dog();
        theDog2.setId(2);
        theDog2.setName("Max");
        dogHandler.addDog(theDog2);

        // Search for a dog with a name that has a single occurrence in the repository
        Dog result = dogHandler.getDogByName("Max");
        Assertions.assertEquals(theDog2, result, "Should return the single Dog object with the unique name");
    }

    @Test
    public void updateDogDetails_ShouldReturnUpdatedDogIdIfExists() {
        DogHandler dogHandler = new DogHandler(dogRepo);
        Dog theDog = new Dog();
        theDog.setId(1);
        theDog.setName("Buddy");
        dogHandler.addDog(theDog);

        theDog.setName("Max");
        long updatedDogId = dogHandler.updateDogDetails(theDog);

        Assertions.assertEquals(1, updatedDogId, "Should return the updated Dog's ID");
        Dog updatedDog = dogHandler.getDogByName("Max");

        Assertions.assertEquals("Max", updatedDog.getName(), "Should update the dog's name");
    }

    @Test
    public void updateDogDetails_ShouldReturnNegativeValueIfDogDoesNotExist() {
        DogHandler dogHandler = new DogHandler(dogRepo);

        Dog theDog = new Dog();
        theDog.setId(1);
        theDog.setName("Buddy");

        long updatedDogId = dogHandler.updateDogDetails(theDog);

        Assertions.assertTrue(updatedDogId < 0, "Should return a negative value if the dog does not exist");
    }
}
