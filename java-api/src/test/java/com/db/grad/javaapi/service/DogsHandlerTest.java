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

}
