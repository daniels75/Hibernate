package org.daniels.example.hibernate.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.daniels.example.hibernate.config.PersistencyConfigForTest;
import org.daniels.example.hibernate.config.TestBeansConfig;
import org.daniels.example.hibernate.model.User;
import org.daniels.example.hibernate.repository.UserJpaRepository;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = { PersistencyConfigForTest.class, TestBeansConfig.class })
public abstract class AbstractSelfCleaningTest {
    
    @Autowired
    protected ApplicationContext applicationContext;
    
    @Autowired
    private UserJpaRepository userRepo;
    
    @Before
    public void setupUser(){
        // given
        User kgr = new User();
        kgr.setName("daniels");
        kgr.setLogin("dels");
        kgr.setId(0L);
        
        User admin = new User();
        admin.setName("admin");
        admin.setLogin("admin");
        admin.setId(0L);

        userRepo.saveAndFlush(kgr);
        userRepo.saveAndFlush(admin);
    }
    
    @After
    public void tearDown() {
        try {
            clearDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearDatabase() throws Exception {
        final DataSource ds = (DataSource) applicationContext.getBean("dataSource");
        Connection connection = null;
        try {
            connection = ds.getConnection();
            try {
                final Statement stmt = connection.createStatement();
                try {
                    stmt.execute("TRUNCATE SCHEMA PUBLIC RESTART IDENTITY AND COMMIT NO CHECK");
                    connection.commit();
                } finally {
                    stmt.close();
                }
            } catch (SQLException e) {
                connection.rollback();
                throw new Exception(e);
            }
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}
