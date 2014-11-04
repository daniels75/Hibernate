package org.daniels.example.hibernate.service;

import java.util.List;

import org.daniels.example.hibernate.model.User;

public interface UserDetailsService {

    User getUserByLogin(final String login);
    
    List<String> getAllUsers();
    
    User getUserByName(final String name);

}
