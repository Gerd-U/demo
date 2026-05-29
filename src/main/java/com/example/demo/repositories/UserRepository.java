package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    default List<User> getAll() {
        return findAll();
        //llama todo de entities que seria product
    }

    default User addUser(User user) {
        return save(user);
    }

    default User updateUser(User user){
        return save(user);
    }

   //////////////////////////////////////////////////////
   Optional<User> findByResourceId(UUID resourceId);//
   //////////////////////////////////////////////////////
    
    default User getByResourceId(UUID resourceId) {
        return this.findByResourceId(resourceId).orElse(null);
       
    }

}

