package com.db.grad.javaapi.service;

import com.db.grad.javaapi.exceptions.DogNotFoundException;
import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;

import java.util.List;

public class DogHandler {

    private DogsRepository itsDogRepo;

    public DogHandler(DogsRepository repo) {
        itsDogRepo = repo;
    }

    public Long addDog(Dog theDog) {
        return itsDogRepo.save(theDog);
    }

    public long getNoOfDogs() {
        return itsDogRepo.count();
    }

    public boolean removeDog(long id){
        if(itsDogRepo.findById(id) != null){
            return itsDogRepo.delete(itsDogRepo.findById(id));
        }
       return false;
    }
    public long updateDogDetails(Dog theDog) {
        if (itsDogRepo.findById(theDog.getId()) != null) {
            return itsDogRepo.save(theDog);
        } else {
            throw new DogNotFoundException();
        }
    }
}
