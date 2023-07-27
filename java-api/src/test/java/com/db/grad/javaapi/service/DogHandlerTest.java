package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
    public void find_dog_by_id_returns_dog(){

        DogHandler cut = new DogHandler(itsDogRepo);

        Dog theDog = new Dog();
        theDog.setName("Bruce");
        cut.addDog(theDog);
        theDog = new Dog();
        theDog.setName("Clark");
        long uniqueID = cut.addDog(theDog);
        Dog expectedDog = theDog;
        theDog = new Dog();
        theDog.setName("Diana");
        cut.addDog(theDog);

        Dog actualResult = cut.getDogById(uniqueID);

        assertEquals(expectedDog.getId(),actualResult.getId());
        assertEquals(expectedDog.getName(),actualResult.getName());

    }

    @Test
    public void find_dog_by_wrong_id_returns_null(){

        DogHandler cut = new DogHandler(itsDogRepo);

        Dog theDog = new Dog();
        theDog.setName("Bruce");
        cut.addDog(theDog);
        theDog = new Dog();
        theDog.setName("Clark");
        long uniqueID = cut.addDog(theDog);
        Dog expectedDog = theDog;
        theDog = new Dog();
        theDog.setName("Diana");
        cut.addDog(theDog);

        Dog actualResult = cut.getDogById(88);

        assertNull(actualResult);

    }


}

