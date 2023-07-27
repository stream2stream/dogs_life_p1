package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;

import java.util.ArrayList;
import  java.util.List;

public class DogHandler {

    private DogsRepository itsDogRepo;
    public DogHandler(DogsRepository repo) {
        itsDogRepo = repo;
    }

    public long addDog(Dog dog) {
        return itsDogRepo.save(dog);
    }

    public long getNoOfDogs() {
        return itsDogRepo.count();
    }

    public Dog getDogByName(String name)
        {

            Dog dog=new Dog();
            dog.setName(name);
            List<Dog> dogs= itsDogRepo.findByName(dog);

            int size=dogs.size();
            if(size==1)
            {
                return  dogs.get(0);
            }
            else
                return null;


        }

}
