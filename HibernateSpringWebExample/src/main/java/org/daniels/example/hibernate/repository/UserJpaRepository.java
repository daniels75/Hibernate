package org.daniels.example.hibernate.repository;

import java.util.List;

import org.daniels.example.hibernate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.login = ?1")
    User findUserByLogin(final String login);
    
    @Query("SELECT u.name FROM User u")
    List<String> findAllUsers();

    @Query("SELECT u FROM User u WHERE u.name = ?1")
    User findUserByName(final String name);

}
