package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;

public class DogHandler {

    private DogsRepository dogsRepository;
    public DogHandler(DogsRepository dogsRepository) {
        this.dogsRepository = dogsRepository;
    }

    public long addDog(Dog dog) {
        return this.dogsRepository.save(dog);
    }

    public long getNoOfDogs() {
        return this.dogsRepository.count();
    }
}
