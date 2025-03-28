package com.examly.springapp.repositories;

import com.examly.springapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.preferredCurrency = :currency")
    List<User> findUsersByPreferredCurrency(String currency);
}


