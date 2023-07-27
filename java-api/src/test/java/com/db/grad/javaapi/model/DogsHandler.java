package com.db.grad.javaapi.model;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DogsHandlerTest {
    private DogsRepository itsDogRepo = new DogsRepositoryStub() {
        @BeforeEach
        public void makeSureRepoIsEmpty() {
            itsDogRepo.deleteAll();
        }
    }
    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one() {
        DogsHandler cut = new DogsHandler();
    }
}
