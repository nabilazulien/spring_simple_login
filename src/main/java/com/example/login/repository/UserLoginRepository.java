package com.example.login.repository;

import com.example.login.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Long>{
    Optional<UserLogin> findByUsername(String username);
}
