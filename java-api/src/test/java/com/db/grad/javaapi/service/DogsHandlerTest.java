package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DogsHandlerTest {

    private final DogsRepository itsDogRepo = new DogsRepositoryStub();
    private DogHandler cut;
    private Dog dog1, dog2, dog3;

    @BeforeEach
    public void cleanRepoAndAddDogsForTesting() {
        // add some dogs for testing
        itsDogRepo.deleteAll();
        cut = new DogHandler(itsDogRepo);
        dog1 = new Dog();
        dog1.setName("Bruno");
        cut.addDog(dog1);
        dog2 = new Dog();
        dog2.setName("Rex");
        cut.addDog(dog2);
        dog3 = new Dog();
        dog3.setName("Max");
        cut.addDog(dog3);
    }

    @Test
    @DisplayName("Test adding one dog")
    public void add_a_dog_return_number_of_dogs_in_repo_is_one() {
        // arrange
        // delete dogs because we need an empty repo for this test
        itsDogRepo.deleteAll();
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);

        // act
        long actualResult = cut.getNoOfDogs();

        // assert
        assertEquals(1, actualResult);
    }

    @Test
    @DisplayName("Test adding multiple dogs")
    public void add_several_dogs_return_number_of_dogs_match_number_added(){
        // arrange is done in beforeEach

        // act
        long actualResult = cut.getNoOfDogs();

        // assert
        assertEquals(3, actualResult);
    }

    @Test
    @DisplayName("DogName: Only one dog with a name")
    public void dog_name_only_one(){
        // arrange is done in beforeEach

        // act
        Dog actualResult = cut.getDogByName("Rex");

        // assert
        assertEquals(dog2, actualResult);
    }

    @Test
    @DisplayName("DogName: No dog with the searched name")
    public void dog_name_no(){
        // arrange is done in beforeEach

        // act
        Dog actualResult = cut.getDogByName("Klaus");

        // assert
        assertNull(actualResult);
    }

    @Test
    @DisplayName("DogName: Multiple dogs with the searched name")
    public void dog_name_multiple(){
        // arrange is done in beforeEach
        Dog dog4 = new Dog();
        dog4.setName("Bruno");
        cut.addDog(dog4);

        // act
        Dog actualResult = cut.getDogByName("Bruno");

        // assert
        assertNull(actualResult);
    }

    @Test
    @DisplayName("DogId not exists")
    void dog_id_not_exist() {
        // arrange is done in beforeEach
        DogHandler cut = new DogHandler(itsDogRepo);

        // act
        Dog actualResult = cut.getDogById(4);

        // assert
        assertNull(actualResult);
    }

    @Test
    @DisplayName("DogId exists")
    void dog_id_exists() {
        // arrange is done in beforeEach

        // act
        Dog actualResult = cut.getDogById(2);

        // assert
        assertEquals(dog2, actualResult);
    }

    @Test
    @DisplayName("Update Dogs ID")
    void update_dogs_id() {
        // arrange is done in beforeEach

        // act
        dog3.setId(9826878);
        long actualResult = cut.updateDogDetails(dog3);

        // assert
        assertEquals(9826878, actualResult);
    }

    @Test
    @DisplayName("Remove a dog")
    void remove_dog() {
        // arrange is done in beforeEach

        // act
        boolean actualResult = cut.removeDog(2);

        // assert
        assertTrue(actualResult);
    }

    @Test
    @DisplayName("Dog cannot be removed")
    void remove_dog_not_possible() {
        // arrange is done in beforeEach

        // act
        boolean actualResult = cut.removeDog(1878);

        // assert
        assertFalse(actualResult);
    }



}
