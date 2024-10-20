package com.codes.SpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codes.SpringBoot.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String user);
}
