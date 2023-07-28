package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;

import java.util.ArrayList;
import java.util.List;


public class DogHandler {
    private DogsRepository itsDogsRepo;
    public DogHandler(DogsRepository repo) {
        itsDogsRepo = repo;
    }
    public long addDog(Dog theDog)
    {
        return itsDogsRepo.save(theDog);
    }
    public long getNoOfDogs()
    {
        return itsDogsRepo.count();
    }

    public boolean existsById(long id) {
        return itsDogsRepo.existsById(id);
    }

    public long updateDogDetails(Dog dog) {
        return itsDogsRepo.save(dog);
    }
    public Dog getDogByName(String dogName){
        Dog newDog = new Dog();
        newDog.setName(dogName);
        List<Dog> newList = new ArrayList<>();
        newList = itsDogsRepo.findByName(newDog);
        if (newList.isEmpty()) {
            return null;
        }else{
            if(newList.size()==1){
                return newList.get(0);
            }else{
                return null;
            }
        }

        }
}
