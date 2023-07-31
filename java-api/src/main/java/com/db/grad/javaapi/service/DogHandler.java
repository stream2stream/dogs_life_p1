package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryJPA;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DogHandler {

    private final DogsRepositoryJPA dogsRepository;

    @Autowired
    public DogHandler(DogsRepositoryJPA dogsRepository) {
        this.dogsRepository = dogsRepository;
    }

    public Dog addDog(Dog theDog) {
        return dogsRepository.save(theDog);
    }

    public long getNoOfDogs() {
        return dogsRepository.count();
    }

    public Optional<Dog> getDogById(long id) {
        Optional<Dog> result =  dogsRepository.findById(id);
        if (result.isPresent()) {
            return result;
        } else {
            throw new NoSuchElementException();
        }

    }

    public Dog getDogByName(String name) {
        Dog dogToFind = new Dog();
        dogToFind.setName(name);
        List<Dog> list = dogsRepository.findAllByName(dogToFind);
        return list.size() > 0 ? dogToFind : null;
    }

    public Dog updateDogDetails(Dog dog) {
        if (dogsRepository.existsById(dog.getId())) {
            return dogsRepository.save(dog);
        } else {
            return null;
        }
    }


    public boolean removeDog(long id) {
         Optional<Dog> dog = dogsRepository.findById(id);
         if (dog.isPresent()) {
             dogsRepository.delete(dog.get());
             return true;
         } else {
             return false;
         }
    }

    public String getAllDogs() {
    }
}

