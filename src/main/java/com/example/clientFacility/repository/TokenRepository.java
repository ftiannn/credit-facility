package com.example.clientFacility.repository;
import com.example.clientFacility.model.Token;
import com.example.clientFacility.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {
    Token findTokenByUser(User user);
    Token findTokenByToken(String token);
}
