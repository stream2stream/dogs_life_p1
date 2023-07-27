package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DogHandlerTest {

    private final DogsRepository itsDogRepo = new DogsRepositoryStub();

    @BeforeEach
    public void makeSureRepoIsEmpty(){
        itsDogRepo.deleteAll();
    }

    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one(){

        //arrange
        DogHandler cut = new DogHandler(itsDogRepo);

        //act
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);
        int expectedResult = 1;

        long actualResult = cut.getNoOfDogs();

        //assert
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void add_several_dog_return_number_of_dogs_match_number_added(){

        //arrange
        DogHandler cut = new DogHandler(itsDogRepo);

        //act
        final int NOFDOGS = 3;
        for(int i = 0; i < NOFDOGS; i++){
            Dog theDog = new Dog();
            theDog.setName("Bruno" + i);
            cut.addDog(theDog);
        }

        long actualResult = cut.getNoOfDogs();

        //assert
        assertEquals(NOFDOGS,actualResult);
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

}
