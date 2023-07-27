package com.db.grad.javaapi.service;

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
        return itsDogRepo.delete(itsDogRepo.findById(id));
    }

    public List<Dog> getDogByName(Dog dogToFind){
        return itsDogRepo.findByName(dogToFind);
    }
}
