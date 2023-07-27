package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;

import java.util.Optional;

public class DogHandler {
    private DogsRepository itsDogsRepo;
    public DogHandler(DogsRepository repo) {
        itsDogsRepo = repo;

    }

    public long addDog(Dog theDog) {
        return itsDogsRepo.save(theDog);
    }

    public long getNoOfDogs() {
        return itsDogsRepo.count();
    }

    public Dog getDogByName(Dog theDog){
        int NoOfName = itsDogsRepo.findByName(theDog).size();
        if (NoOfName == 1){
            return theDog;
        }
        else{
            return null;}
    }

    public Dog getDogById(long id){
        return itsDogsRepo.findById(id);
    }

    long updateDogDetails(Dog dog){
        return itsDogsRepo.save(dog);
    }

    boolean removeDog(long id){
        boolean result =  false;
        Dog toRemove = itsDogsRepo.findById(id);
        if(toRemove != null){
            itsDogsRepo.delete(toRemove);
            result = true;
        }
        return result;
    }


}
