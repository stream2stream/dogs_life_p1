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

    public Dog getDogByName(String name){

        Dog dog = new Dog(name);

        List <Dog> listOfDogs = itsDogsRepo.findByName(dog);

        if (listOfDogs.size() != 1)
            return null;
        else
            return listOfDogs.get(0);


        //return itsDogsRepo.findByName(dog);
    }

    public Dog getDogByID(long id){

        Dog dog = new Dog();
        dog.setId(id);

        return itsDogsRepo.findById(id);
    }
}
