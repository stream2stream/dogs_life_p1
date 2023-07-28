package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DogHandlerTest {

    private DogsRepository itsDogRepo = new DogsRepositoryStub();
    @BeforeEach
    public void makeSureRepoIsEmpty(){
        itsDogRepo.deleteAll();
    }

    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one() {
        //arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);
        int expectedResult = 1;

        //act
        long actualResult = cut.getNoOfDogs();

        //assert
        assertEquals( expectedResult, actualResult );
    }

    @Test
    public void add_several_dogs_return_number_of_dogs_match_number_added() {
        //arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog1 = new Dog();
        theDog1.setName("Stephan");
        cut.addDog(theDog1);

        Dog theDog2 = new Dog();
        theDog2.setName("Pontius");
        cut.addDog(theDog2);
        int expectedResult = 2;

        //act
        long actualResult = cut.getNoOfDogs();

        //assert
        assertEquals( expectedResult, actualResult );
    }
}
