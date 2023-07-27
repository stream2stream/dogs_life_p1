package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;

public class DogHandler {
    private DogsRepository itsDogsRepo;
    public DogHandler(DogsRepository repo)
    {
        itsDogsRepo = repo;
    }
    public long addDog(Dog theDog){
        return itsDogsRepo.save(theDog);
    }


    public long getNoOfDogs() {

        return itsDogsRepo.count();
    }

    public long updateDogDetails(Dog dogToUpdate) {
        return itsDogsRepo.save( dogToUpdate );
    }
    public boolean removeDog(long uniqueId) {
        boolean result = false;

        Dog theDog = itsDogsRepo.findById(uniqueId);
        if (theDog != null) {
            result = itsDogsRepo.delete(theDog);
        }

        return result;
    }
     }


