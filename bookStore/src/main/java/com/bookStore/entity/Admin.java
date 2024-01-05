package com.bookStore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADMIN")

public class Admin {
    @Id
     private long id;
    private String name;
    private String lastName;
    private String Email;
    private String password;

}
