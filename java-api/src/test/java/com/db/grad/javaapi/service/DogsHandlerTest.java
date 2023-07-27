package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DogsHandlerTest {

    private DogsRepository itsDogRepo = new DogsRepositoryStub();

    @BeforeEach
    public void makeSureRepoIsEmpty(){
        itsDogRepo.deleteAll();
    }

    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one(){
        //arange
        DogsHandler cut = new DogsHandler(itsDogRepo);
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
    public void add_a_dog_return_name(){
        //arange
        DogsHandler cut = new DogsHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);

        String expectedResult = "Bruno";

        //act
        String actualResult = cut.getNameOfDog(theDog);

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void return_dog_by_name(){
        //arange
        DogsHandler cut = new DogsHandler(itsDogRepo);
        Dog theDog = new Dog("Bruno");

        cut.addDog(theDog);

        Dog expectedResult = theDog;

        //act
        Dog actualResult = cut.getDogByName("Bruno");

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void return_dog_by_id(){
        //arange
        DogsHandler cut = new DogsHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setId(1L);

        cut.addDog(theDog);

        Dog expectedResult = theDog;

        //act
        Dog actualResult = cut.getDogByID(1L);

        //assert
        assertEquals(expectedResult, actualResult);
    }
}
