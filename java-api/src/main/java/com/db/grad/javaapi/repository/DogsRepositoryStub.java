package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Dog;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DogsRepositoryStub implements DogsRepository {
    private ArrayList<Dog> itsDogs = new ArrayList<>();

    private long addDog(Dog theDog) {
        long result = 0;
        itsDogs.add(theDog);
        result = itsDogs.size();
        theDog.setId(result);
        return result;
    }

    @Override
    public Optional<Dog> findById(long id) {
        Dog result = null;

        for( Dog theDog: itsDogs)
            if(theDog.getId() == id ) {
                result = theDog;
                break;
            }

        return result == null ? Optional.empty() : Optional.of(result);
    }

    @Override
    public List<Dog> findByName(Dog aDog) {
        ArrayList<Dog> result = new ArrayList<>();

        for( Dog theDog: itsDogs)
            if( theDog.getName().equalsIgnoreCase(aDog.getName()) ) {
                result.add(theDog);
            }

        return result;
    }

    @Nullable
    @Override
    public Dog save(Dog aDog) {
        Dog retrievedDog = null;
        long result = -1;

        for( Dog theDog: itsDogs)
            if( theDog.getId() == aDog.getId()) {
                retrievedDog = theDog;
                retrievedDog.setName( aDog.getName() );
                result = retrievedDog.getId();
                break;
            }
        if( retrievedDog == null )
            result = addDog(aDog);

        if (result < 0) {
            return null;
        } else {
            return retrievedDog;
        }

    }

    @Override
    public boolean delete(Dog aDog) {
        boolean result = false;
        long initialSize = itsDogs.size();

        itsDogs.removeIf(dog -> dog.getId() == aDog.getId());
        result = initialSize != itsDogs.size();

        return result;
    }

    @Override
    public  long count()
    {
        return this.itsDogs.size();
    }

    @Override
    public  boolean existsById( long id )
    {
        boolean result = false;

        for( Dog theDog: itsDogs)
            if(theDog.getId() == id ) {
                result = true;
                break;
            }

        return result;
    }

    @Override
    public  void    deleteAll()
    {
        itsDogs.clear();
    }

    @Override
    public Dog getDogByName(String name) {
        Dog result = null;
        for (Dog theDog : itsDogs) {
            if (theDog.getName().equalsIgnoreCase(name)) {
                if (result != null) {
                    // If we already found one dog with the given name,
                    // it means there are multiple dogs with the same name, so return null.
                    return null;
                }
                result = theDog;
            }
        }
        return result;

    }

}
