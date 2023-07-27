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
    public void makeSureRepoIsEmpty(){
        itsDogRepo.deleteAll();
    }

    @Test
    public void add_a_return_number_of_dogs_in_repo_is_one(){
        //arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);

        int expectedResult = 1;
        //act
        long actualResult = cut.getNoOfDogs();
        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void add_several_dogs_return_number_of_dogs_match_number_added(){
        //arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        cut.addDog(dog1);
        cut.addDog(dog2);

        int expectedResult = 2;
        //act
        long actualResult = cut.getNoOfDogs();
        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void get_a_dogs_name_which_match_the_name(){
        //arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog dog1 = new Dog();
        dog1.setName("Money");
        Dog dog2 = new Dog();
        dog2.setName("Coin");
        cut.addDog(dog1);
        cut.addDog(dog2);

        String expectedResult = "Money";
        //act
        String actualResult = cut;
        //assert
        assertEquals(expectedResult, actualResult);
    }


}
