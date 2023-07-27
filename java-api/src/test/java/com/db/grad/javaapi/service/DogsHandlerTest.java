package test.java.com.db.grad.javaapi.service;

public class DogsHandlerTest
{
    private DogsRepository itsDogRepo = new DogsRepositoryStub();

    @BeforeEach
    public void makeSureRepoIsEmpty()
    {
        itsDogRepo.deleteAll();
    }

    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one()
    {
        //arrange
        Doghandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setname("Bruno");
        cut.addDog(theDog);

        int expectedResult = 1;

        //act
        long actualResult = cut.getNoOfDogs();

        //assert
        assertEquals( expectedResult, actualResult );
    }
}
