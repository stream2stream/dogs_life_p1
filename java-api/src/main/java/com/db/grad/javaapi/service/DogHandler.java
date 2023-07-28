package com.db.grad.javaapi.service;
import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;

import java.util.ArrayList;
import java.util.List;

public class DogHandler {

    private DogsRepository itsDogRepo;
    public DogHandler(DogsRepository repo) {
        itsDogRepo = repo;
    }

    public long addDog(Dog theDog) {
        return itsDogRepo.save(theDog);
    }

    public long getNoOfDogs() {
        return itsDogRepo.count();
    }

    public Dog getDogByName(String name) {
        List<Dog> dogs = new ArrayList<Dog>();
        for (int x = 1; itsDogRepo.count() >= x; x++){
            dogs.add(itsDogRepo.findById(x));
        }
        List<Dog> dogsWithName = new ArrayList<Dog>();
        for (Dog dog : dogs){
            if(dog.getName() == name){
            dogsWithName.addAll(itsDogRepo.findByName(dog));}
        }
        if (dogsWithName.size() == 1){
            return dogsWithName.get(0);
        } else{
            return null;
        }
    }

    public Dog findById(long i) {
        return itsDogRepo.findById(i);
    }
    public long updateDogDetails( Dog dog ) {
        itsDogRepo.save(dog);
        return dog.getId();
    }

    public boolean removeDog(long dogId) {
        Dog dog = itsDogRepo.findById(dogId);
        return itsDogRepo.delete(dog);

    }

}
