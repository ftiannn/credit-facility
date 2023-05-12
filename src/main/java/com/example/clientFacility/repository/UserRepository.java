package com.example.clientFacility.repository;
import com.example.clientFacility.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();

    User findByEmail(String email);

    User findByUserName(String userName);

}
