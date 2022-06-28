package com.home.knowbaseservice.repository;

import com.home.knowbaseservice.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("""
            SELECT u FROM User  u WHERE u.loginEmail=:email AND u.isEnabled=:isEnabled
            """)
    Optional<User> findByEmail(String email, Boolean isEnabled);

    @Query("""
            SELECT u FROM User u WHERE u.loginEmail=:email AND u.passwordHash=:passwordHash AND u.isEnabled=true
            """)
    Optional<User> findByCredentials(String email, String passwordHash);
}
