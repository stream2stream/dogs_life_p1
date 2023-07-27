package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;

public class DogHandler {

    private final DogsRepository dogsRepository;

    public DogHandler(DogsRepository dogsRepository){
        this.dogsRepository = dogsRepository;
    }

    public long addDog(Dog theDog) {
        return dogsRepository.save(theDog);
    }

    public long getNoOfDogs(){
        return dogsRepository.count();
    }

    public Dog getDogById(long id) {return dogsRepository.findById(id);}
}
