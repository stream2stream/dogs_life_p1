package com.db.grad.javaapi.service;
import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;

import java.util.ArrayList;
import java.util.List;

public class DogHandler {

    private DogsRepository itsDogRepo;
    private List<Dog> dogs = new ArrayList<>(); //Here we create a list of dogs
    public DogHandler(DogsRepository repo) {
        itsDogRepo = repo;
    }

    public long addDog(Dog theDog) {
        return itsDogRepo.save(theDog);
       //line added we need a fix dogs.add(theDog); //Here we add to the list the dogs
    }

    public long getNoOfDogs() {
        return itsDogRepo.count();
     //line added we need a fix   return dogs.size();//Here we get the size of the list
    }

    public Dog getDogByName(String name) {
        Dog foundDog = null;
        for (Dog dog : dogs) {
            if (dog.getName().equalsIgnoreCase(name)) {
                foundDog =  dog;//Return the first dog with the matching name

            }
        }
        return foundDog; //return the dog object
        //new changes
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
