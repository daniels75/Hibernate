package org.daniels.example.hibernate.model;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User implements Serializable {

    private static final long serialVersionUID = 2987841788026262723L;
    private Long id;
    private String name;
    private String login;

    @Id
    @Column(nullable=false, name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(length = 64, name="LoginName")
    public String getLogin() {
        return login;
    }
    public void setLogin(final String login){
        this.login = login;
    }

    @Column(length = 64, name="Name")
    public String getName() {
        return name;
    }
    
    public void setName(final String name){
        this.name = name;
    }
    
}
