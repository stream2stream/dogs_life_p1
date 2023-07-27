package com.db.grad.javaapi.service;

import com.db.grad.javaapi.exceptions.DogNotFoundException;
import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DogHandlerTest {

    private final DogsRepository itsDogRepo = new DogsRepositoryStub();

    @BeforeEach
    public void makeSureRepoIsEmpty() {
        itsDogRepo.deleteAll();
    }

    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one() {

        //arrange
        DogHandler cut = new DogHandler(itsDogRepo);

        //act
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);
        int expectedResult = 1;

        long actualResult = cut.getNoOfDogs();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void add_several_dog_return_number_of_dogs_match_number_added() {

        //arrange
        DogHandler cut = new DogHandler(itsDogRepo);

        //act
        final int NOFDOGS = 3;
        for (int i = 0; i < NOFDOGS; i++) {
            Dog theDog = new Dog();
            theDog.setName("Bruno" + i);
            cut.addDog(theDog);
        }

        long actualResult = cut.getNoOfDogs();

        //assert
        assertEquals(NOFDOGS, actualResult);
    }

    @Test
    public void remove_dog_and_return_true_if_removed(){

        //arrange
        DogHandler cut = new DogHandler(itsDogRepo);

        //act
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        Long idOfTheDog = cut.addDog(theDog);

        boolean actualResult = cut.removeDog(idOfTheDog);

        boolean expectedResult = true;

        //assert

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void remove_dog_that_is_not_in_db_return_false(){

        //arrange
        DogHandler cut = new DogHandler(itsDogRepo);

        //act
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        Long idOfTheDog = cut.addDog(theDog);

        long noOfDogs = cut.getNoOfDogs();
        boolean actualResult = cut.removeDog(noOfDogs+1);
        boolean expectedResult = false;

        assertEquals(actualResult,expectedResult);
        
    }

    @Test
    public void update_dog_that_exists_returns_dog_id() {
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        long expectedId = cut.addDog(theDog);
        theDog.setName("NotBruno");

        long actualId = cut.updateDogDetails(theDog);

        assertEquals(expectedId, actualId);
    }

    @Test
    public void update_dog_that_not_exists_throws() {
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);
        Dog theSecondDog = new Dog();
        theSecondDog.setName("NotBruno");

        assertThrows(DogNotFoundException.class, () -> cut.updateDogDetails(theSecondDog));
    }
}
