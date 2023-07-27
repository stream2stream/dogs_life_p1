package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;

public class DogHandler {
    private DogsRepository dogsRepository;
    public DogHandler(DogsRepository repo) {
        this.dogsRepository=repo;
    }

    public long addDog(Dog theDog) {
        return dogsRepository.save(theDog);
    }

    public long getNoOfDogs() {
        return  dogsRepository.count();
    }
}
