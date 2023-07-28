/*package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    @Test
    public void testGetDogById() {
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);
        // Dog 2 to fail the test
        Dog theDog2 = new Dog();
        theDog2.setName("Dog2");
        cut.addDog(theDog2);

        Dog expectedResult = theDog;
        Dog actualResult = cut.findById(1L);
        assertEquals(expectedResult, actualResult, "Sorry, could not find the dog");
    }
    @Test
    public void addSeveralDogsReturnNumberOfDogsMatchNumberAdded(){
        DogHandler dogHandler = new DogHandler(itsDogRepo);

        Dog dog1 = new Dog();
        dog1.setName("Max");
        dogHandler.addDog( dog1 );

        Dog dog2 = new Dog();
        dog2.setName("John");
        dogHandler.addDog( dog2 );

        Dog dog3 = new Dog();
        dog3.setName("Wick");
        dogHandler.addDog( dog3 );

        assertEquals(3, dogHandler.getNoOfDogs(), "Number of dogs does not match the number added");
    }

    @Test
    public void getDogByName(){
        DogHandler dogHandler = new DogHandler(itsDogRepo);
        //dog1
        Dog dog1 = new Dog();
        dog1.setName("Max");
        dogHandler.addDog(dog1);
        //dog2
        Dog dog2 = new Dog();
        dog2.setName("John");
        dogHandler.addDog(dog2);

        Dog dog3 = new Dog();
        dog3.setName("John");
        dogHandler.addDog(dog3);

        //Case 1: Dog with the given name exists
        Dog resultDog1 = dogHandler.getDogByName(dog1.getName());
        assertNotNull(resultDog1, "Dog should not be null");
        assertEquals(dog1.getName(), resultDog1.getName(), "Dog exists");

        //Case 2: Several Dogs exists with the same name - should return null
        Dog resultDog2 = dogHandler.getDogByName(dog2.getName());
        assertNull(resultDog2, "Dog should be null as there are several Dogs existing with the same name");
    }

    @Test
    public void checkIfDogIDIsUpdated(){
        DogHandler dogHandler = new DogHandler(itsDogRepo);

        Dog dog1 = new Dog();
        dog1.setId(56);

        assertEquals(56, dog1.getId());

        dog1.setId(1L);

        dogHandler.updateDogDetails(dog1);

        assertEquals(1L, dog1.getId());
    }

    @Test
    public void addAndRemoveDog(){
        DogHandler dogHandler = new DogHandler(itsDogRepo);

        Dog dog1 = new Dog();
        dog1.setName("Max");
        dogHandler.addDog( dog1 );

        Dog dog2 = new Dog();
        dog2.setName("Max2");
        dogHandler.addDog( dog2 );

        Dog dog3 = new Dog();
        dog3.setName("Max3");
        dogHandler.addDog( dog3 );

        dogHandler.removeDog(1);
        assertEquals(2, dogHandler.getNoOfDogs());

    }
}*/

package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DogsHandlerTest
{
    @Mock
    private DogsRepository itsDogsRepo;

    @InjectMocks
    private DogHandler cut;

    @Test
    public  void    add_a_dog_return_number_of_dogs_in_repo_is_one()
    {
        // arrange
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        Mockito.when(itsDogsRepo.save(theDog)).thenReturn(theDog);
        Mockito.when(itsDogsRepo.count()).thenReturn(1L);
        cut.addDog( theDog );

        int expectedResult = 1;

        // act
        long actualResult = cut.getNoOfDogs();

        // assert
        assertEquals( expectedResult, actualResult );
    }

    @Test
    public  void    add_several_dogs_return_number_of_dogs_match_number_added()
    {
        // arrange
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        theDog = new Dog();
        theDog.setName("Frank");
        cut.addDog( theDog );
        theDog = new Dog();
        theDog.setName("Penny");
        cut.addDog( theDog );
        Mockito.when(itsDogsRepo.count()).thenReturn(3L);

        int expectedResult = 3;

        // act
        long actualResult = cut.getNoOfDogs();

        // assert
        assertEquals( expectedResult, actualResult );
    }

    @Ignore
    @Test
    public  void    add_dog_and_remove_dog_return_number_of_dogs_is_zero()
    {
        // arrange
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        Mockito.when(itsDogsRepo.save(theDog)).thenReturn(theDog);
        Dog uniqueDog = cut.addDog( theDog );

        Optional<Dog> opt = Optional.of(theDog);
        Mockito.when(itsDogsRepo.findById(theDog.getId())).thenReturn(opt);

        long expectedResult = 0;
        boolean expectedStatus = true;

        // act
        boolean actualStatus = cut.removeDog( uniqueDog.getId() );
        long actualResult = cut.getNoOfDogs();

        // assert
        assertEquals( expectedStatus, actualStatus);
        assertEquals( expectedResult, actualResult );
        verify(itsDogsRepo, times(1)).delete(theDog);
    }

    // This test covers the other logic path in cut.removeDog()
    @Ignore
    @Test
    public  void    add_dog_and_remove_dog_that_doess_not_exist_return_number_of_dogs_is_one()
    {
        // arrange
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        Dog uniqueDog = cut.addDog( theDog );

        long invalidId = 33;
        long expectedResult = 1;
        boolean expectedStatus = false;

        Optional<Dog> opt = Optional.empty();
        Mockito.when(itsDogsRepo.findById(invalidId)).thenReturn(opt);

        Mockito.when(itsDogsRepo.count()).thenReturn(1L);

        // act
        // There is no dog with ID == 33
        boolean actualStatus = cut.removeDog( invalidId );
        long actualResult = cut.getNoOfDogs();

        // assert
        assertEquals( expectedStatus, actualStatus);
        assertEquals( expectedResult, actualResult );
        verify(itsDogsRepo, times(0)).delete(theDog);
    }

    @Test
    public  void    find_dog_by_valid_id_returns_one_dog()
    {
        // arrange
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        theDog = new Dog();
        theDog.setName("Frank");
        Mockito.when(itsDogsRepo.save(theDog)).thenReturn(theDog);
        Dog addedDog = cut.addDog( theDog );
        Dog expectedDog = theDog;
        theDog = new Dog();
        theDog.setName("Penny");
        cut.addDog( theDog );

        Dog jpaDog = addedDog;
        Optional<Dog> opt = Optional.of(addedDog);
        Mockito.when(itsDogsRepo.findById(addedDog.getId())).thenReturn(opt);

        // act
        Dog actualResult = cut.getDogById( addedDog.getId() );

        // assert
        assertEquals( expectedDog.getId(), actualResult.getId() );
        assertEquals( expectedDog.getName(), actualResult.getName() );
    }

    @Ignore
    @Test
    public  void    find_dog_by_invalid_id_returns_null_dog()
    {
        // arrange
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        theDog = new Dog();
        theDog.setName("Frank");
        cut.addDog( theDog );
        theDog = new Dog();
        theDog.setName("Penny");
        cut.addDog( theDog );
        long invalidId = 33;

        Optional<Dog> opt = Optional.empty();
        Mockito.when(itsDogsRepo.findById(invalidId)).thenReturn(opt);

        // act
        assertThrows(NoSuchElementException.class, () -> {
            cut.getDogById( invalidId );
        });
    }

    @Test
    public  void    find_dog_by_name_returns_one_dog()
    {
        // arrange
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        theDog = new Dog();
        theDog.setName("Frank");
        cut.addDog( theDog );
        Dog expectedDog = theDog;
        String dogToFind = "Frank";
        theDog = new Dog();
        theDog.setName("Penny");
        cut.addDog( theDog );
        ArrayList<Dog> expectedList = new ArrayList<>();
        expectedList.add(expectedDog);
        Mockito.when(itsDogsRepo.findByName(Mockito.any())).thenReturn(expectedList);

        // act
        Dog actualResult = cut.getDogByName( dogToFind );

        // assert
        assertEquals( expectedDog.getId(), actualResult.getId() );
        assertEquals( expectedDog.getName(), actualResult.getName() );
    }


    @Test
    public  void    find_dog_by_name_returns_null_because_many_dogs_with_same_name()
    {
        // arrange
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        Dog expectedDog = theDog;
        String dogToFind = "Bruno";
        theDog = new Dog();
        theDog.setName("Penny");
        cut.addDog( theDog );
        ArrayList<Dog> expectedList = new ArrayList<>();
        Mockito.when(itsDogsRepo.findByName(Mockito.any())).thenReturn(expectedList);

        // act
        Dog actualResult = cut.getDogByName( dogToFind );

        // assert
        assertNull( actualResult );
    }

    @Test
    public  void    find_dog_by_invalid_name_returns_null_dog()
    {
        // arrange
//        DogHandler cut = new DogHandler();
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        theDog = new Dog();
        theDog.setName("Frank");
        cut.addDog( theDog );
        theDog = new Dog();
        theDog.setName("Penny");
        cut.addDog( theDog );
        ArrayList<Dog> expectedList = new ArrayList<>();
        Mockito.when(itsDogsRepo.findByName(Mockito.any())).thenReturn(expectedList);

        // act
        Dog actualResult = cut.getDogByName( "Selvyn" );

        // assert
        assertNull( actualResult );
    }

    @Ignore
    @Test
    public  void    update_dog_that_exists_returns_dog_id()
    {
        // arrange
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        theDog = new Dog();
        theDog.setName("Frank");
        Mockito.when(itsDogsRepo.save(theDog)).thenReturn(theDog);
        Dog expectedDog = cut.addDog( theDog );
        Dog dogToUpdate = theDog;
        String dogToFind = "Frank";
        theDog = new Dog();
        theDog.setName("Penny");
        cut.addDog( theDog );
        Mockito.when(itsDogsRepo.save(dogToUpdate)).thenReturn(dogToUpdate);

        // act
        dogToUpdate.setName("Charlie");
        Dog actualDog = cut.updateDogDetails( dogToUpdate );

        // assert
        assertEquals( expectedDog, actualDog );
    }
}
