package test.java.com.db.grad.javaapi.serv
public class Doghandler {
    public long addDog(Dog theDog);{
        return itsDogsRepo.save(theDog);
}
    public long getNoOfDogs();
    {
        return itsDogsRepo.count();
}
}
