package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;

public class DogsHandler {

    private DogsRepository itsDogsRepo;

    public DogsHandler(DogsRepository repo) {

        itsDogsRepo = repo;
    }

    public long addDog(Dog theDog) {

        return itsDogsRepo.save(theDog);
    }

    public long getNoOfDogs() {

        return itsDogsRepo.count();
    }
}
