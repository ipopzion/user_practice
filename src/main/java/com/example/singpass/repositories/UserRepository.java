package com.example.singpass.repositories;

import com.example.singpass.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByNric(String nric);
    public boolean existsByNric(String nric);
}
