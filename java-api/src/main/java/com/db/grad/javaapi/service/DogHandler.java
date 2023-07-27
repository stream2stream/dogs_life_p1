package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;

import java.util.List;

public class DogHandler {

    private DogsRepository itsDogsRepo;

    public DogHandler(DogsRepository itsDogRepo) {
        this.itsDogsRepo = itsDogRepo;
    }


    public long addDog(Dog theDog) {
        return itsDogsRepo.save(theDog);
    }

    public long getNoOfDogs() {
        return itsDogsRepo.count();
    }

    public Dog getDogByName(String dogname) {
        Dog dummyDog = new Dog();
        dummyDog.setName(dogname);

        // get all dogs with name
        List<Dog> resultList = itsDogsRepo.findByName(dummyDog);

        if(resultList.isEmpty()) {
            return null;
        } else if(resultList.size() == 1) {
            return resultList.get(0);
        } else {
            // more dogs with same name
            return null;
        }
    }

    public Dog getDogById(int i) {
        return itsDogsRepo.findById(i);
    }

    public long updateDogDetails(Dog dog) {
        return dog.getId();
    }
}
