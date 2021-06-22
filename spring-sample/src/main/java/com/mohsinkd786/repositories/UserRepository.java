package com.mohsinkd786.repositories;

import com.mohsinkd786.repositories.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    void deleteByUserId(String userId);
    User findByUserId(String userId);
}
