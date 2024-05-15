package com.example.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    List<Customer> findByFirstName(String firstName);

    Customer findById(long id);

    void deleteById(Long id);
    //Também podemos fazer Custom delete(id, firstName, lastName);

    
}