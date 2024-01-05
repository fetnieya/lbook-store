package com.bookStore.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "MEMBER")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String lastName;

    @Column(name = "email")
    private String email;

    @ManyToMany
    @JoinTable(
            name = "Reservation",
            joinColumns = @JoinColumn(name = "member_id"), // Column in Reservation table referring to Member
            inverseJoinColumns = @JoinColumn(name = "book_id") // Column in Reservation table referring to Book
    )
    private Set<Book> books;


    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Set<Book> getBooks() {
        return books;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
