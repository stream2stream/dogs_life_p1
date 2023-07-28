package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Dog;

import java.util.List;
import java.util.Optional;

public interface DogsRepository {
    Dog save(Dog theDog );
    Optional<Dog>  findById(long id );
    List<Dog> findByName(Dog theDog);
    boolean delete( Dog theDog );
    long count();
    boolean existsById( long id );

    // Additional admin functionality
    void deleteAll();
    Dog getDogByName(String name);
}
