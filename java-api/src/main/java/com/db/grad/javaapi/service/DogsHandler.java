package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;

import java.util.ArrayList;
import java.util.List;

public class DogsHandler {

    private DogsRepository itsDogsRepo;
    public DogsHandler(DogsRepository repo) {
        this.itsDogsRepo = repo;
    }

    public long addDog(Dog theDog) {
        return itsDogsRepo.save(theDog);
    }

    public long getNoOfDogs() {
        return itsDogsRepo.count();
    }

    public String getNameOfDog(Dog searchedDog){
        List<Dog> result = itsDogsRepo.findByName(searchedDog);

        String aux = null;

        for (Dog dogs:result)
            aux = dogs.getName();

        return aux;
    }
}
