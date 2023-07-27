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

    @BeforeEach
    public void makeSureRepoIsEmpty() {
        itsDogRepo.deleteAll();
    }

    @Test
    @DisplayName("Test adding one dog")
    public void add_a_dog_return_number_of_dogs_in_repo_is_one() {
        // arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);
        int expectedResult = 1;

        // act
        long actualResult = cut.getNoOfDogs();

        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test adding multiple dogs")
    public void add_several_dogs_return_number_of_dogs_match_number_added(){
        // arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog dog1 = new Dog();
        dog1.setName("Bruno");
        cut.addDog(dog1);
        Dog dog2 = new Dog();
        dog2.setName("Rex");
        cut.addDog(dog2);
        Dog dog3 = new Dog();
        dog3.setName("Bello");
        cut.addDog(dog3);
        int expectedResult = 3;

        // act
        long actualResult = cut.getNoOfDogs();

        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("DogName: Only one dog with a name")
    public void dog_name_only_one(){
        // arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog dog1 = new Dog();
        dog1.setName("Bruno");
        cut.addDog(dog1);
        Dog dog2 = new Dog();
        dog2.setName("Rex");
        cut.addDog(dog2);

        // act
        Dog actualResult = cut.getDogByName("Rex");

        // assert
        assertEquals(dog2, actualResult);
    }

    @Test
    @DisplayName("DogName: No dog with the searched name")
    public void dog_name_no(){
        // arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog dog1 = new Dog();
        dog1.setName("Bruno");
        cut.addDog(dog1);
        Dog dog2 = new Dog();
        dog2.setName("Rex");
        cut.addDog(dog2);

        // act
        Dog actualResult = cut.getDogByName("Klaus");

        // assert
        assertNull(actualResult);
    }

    @Test
    @DisplayName("DogName: Multiple dogs with the searched name")
    public void dog_name_multiple(){
        // arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog dog1 = new Dog();
        dog1.setName("Bruno");
        cut.addDog(dog1);
        Dog dog2 = new Dog();
        dog2.setName("Rex");
        cut.addDog(dog2);
        Dog dog3 = new Dog();
        dog3.setName("Bruno");
        cut.addDog(dog3);

        // act
        Dog actualResult = cut.getDogByName("Bruno");

        // assert
        assertNull(actualResult);
    }

    @Test
    @DisplayName("DogId not exists")
    void dog_id_not_exist() {
        // arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog dog1 = new Dog();
        dog1.setName("Bruno");
        dog1.setId(1241241);
        cut.addDog(dog1);
        Dog dog2 = new Dog();
        dog2.setName("Rex");
        dog2.setId(555555);
        cut.addDog(dog2);
        Dog dog3 = new Dog();
        dog3.setName("Bruno");
        dog3.setId(9876543);
        cut.addDog(dog3);

        // act
        Dog actualResult = cut.getDogById(232463429);

        // assert
        assertNull(actualResult);
    }

    @Test
    @DisplayName("DogId exists")
    void dog_id_exists() {
        // arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog dog1 = new Dog();
        dog1.setName("Bruno");
        cut.addDog(dog1);
        Dog dog2 = new Dog();
        dog2.setName("Rex");
        cut.addDog(dog2);
        Dog dog3 = new Dog();
        dog3.setName("Bruno");
        cut.addDog(dog3);

        // act
        Dog actualResult = cut.getDogById(2);

        // assert
        assertEquals(dog2, actualResult);
    }

    @Test
    @DisplayName("DogId exists")
    void dog_id_not_exists() {
        // arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog dog1 = new Dog();
        dog1.setName("Bruno");
        cut.addDog(dog1);
        Dog dog2 = new Dog();
        dog2.setName("Rex");
        cut.addDog(dog2);
        Dog dog3 = new Dog();
        dog3.setName("Bruno");
        cut.addDog(dog3);

        // act
        Dog actualResult = cut.getDogById(4);

        // assert
        assertNull(actualResult);
    }

    @Test
    @DisplayName("Update Dogs ID")
    void update_dogs_id() {
        // arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog dog1 = new Dog();
        dog1.setName("Bruno");
        cut.addDog(dog1);
        Dog dog2 = new Dog();
        dog2.setName("Rex");
        cut.addDog(dog2);
        Dog dog3 = new Dog();
        dog3.setName("Bruno");
        cut.addDog(dog3);

        // act
        dog3.setId(9826878);
        long actualResult = cut.updateDogDetails(dog3);

        // assert
        assertEquals(9826878, actualResult);
    }

    @Test
    @DisplayName("Remove a dog")
    void remove_dog() {
        // arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog dog1 = new Dog();
        dog1.setName("Bruno");
        cut.addDog(dog1);
        Dog dog2 = new Dog();
        dog2.setName("Rex");
        cut.addDog(dog2);
        Dog dog3 = new Dog();
        dog3.setName("Bruno");
        cut.addDog(dog3);

        // act
        boolean actualResult = cut.removeDog(2);

        // assert
        assertTrue(actualResult);
    }

    @Test
    @DisplayName("Dog cannot be removed")
    void remove_dog_not_possible() {
        // arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog dog1 = new Dog();
        dog1.setName("Bruno");
        cut.addDog(dog1);
        Dog dog2 = new Dog();
        dog2.setName("Rex");
        cut.addDog(dog2);
        Dog dog3 = new Dog();
        dog3.setName("Bruno");
        cut.addDog(dog3);

        // act
        boolean actualResult = cut.removeDog(1878);

        // assert
        assertFalse(actualResult);
    }



}
