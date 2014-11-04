package org.daniels.example.hibernate.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.daniels.example.hibernate.model.User;
import org.daniels.example.hibernate.service.UserDetailsService;
import org.daniels.example.hibernate.util.AbstractSelfCleaningTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserDetailsServiceImplTest extends AbstractSelfCleaningTest
{
    @Autowired
    private UserDetailsService userService;
    
    @Test
    public void testGetUserByLogin(){
        final User user = userService.getUserByLogin("dels");
        final User fakeUser = userService.getUserByLogin("fake");
        assertEquals("daniels", user.getName());
        assertNull(fakeUser);
    }
    
    @Test
    public void testGetUserByName(){
        final User user = userService.getUserByName("daniels");
        final User fakeUser = userService.getUserByName("FAKE");
        assertEquals("daniels", user.getName());
        assertNull(fakeUser);
    }
    
    @Test
    public void testGetUsers(){
        final List<String> users = userService.getAllUsers();
        assertTrue(users.contains("daniels"));
        assertTrue(users.contains("admin"));
    }
    
}
