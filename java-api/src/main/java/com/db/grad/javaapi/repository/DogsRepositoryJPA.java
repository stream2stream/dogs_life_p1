package com.db.grad.javaapi.repository;


import com.db.grad.javaapi.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DogsRepositoryJPA extends JpaRepository<Dog, Long> {
    Dog save(Dog theDog );
    Optional<Dog> findById(long id );
    Optional<Dog> findByName(Dog theDog);
    List<Dog> findAllByName(Dog theDog);
    boolean remove( Dog theDog );
    void deleteById(Long aLong);
    void delete(Dog dog);
    // Additional admin functionality
    Dog getDogByName(String name);
    void deleteAll();
}
