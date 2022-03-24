package com.authentication.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.authentication.models.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long> {
 //finds a user with a specific email
 Optional<User> findByEmail(String email);
 //A list of all users
 List<User> findAll();
 //finds a specific user with a specific id
 Optional<User> findById(Long id);
 
}
