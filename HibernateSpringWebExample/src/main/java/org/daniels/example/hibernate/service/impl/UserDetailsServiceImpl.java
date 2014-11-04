package org.daniels.example.hibernate.service.impl;

import java.util.List;

import org.daniels.example.hibernate.model.User;
import org.daniels.example.hibernate.repository.UserJpaRepository;
import org.daniels.example.hibernate.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserJpaRepository userRepo;

    @Override
    public User getUserByLogin(final String login) {
        final User user = userRepo.findUserByLogin(login);
        return user;
    }
    
    @Override
    public List<String> getAllUsers() {
        final List<String> users = userRepo.findAllUsers();
        return users;
    }

    @Override
    public User getUserByName(final String name) {
        final User user = userRepo.findUserByName(name);
        return user;
    }

}
