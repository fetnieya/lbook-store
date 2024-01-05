package com.bookStore.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="LOAN")
public class Loan {
    @Id
    private int id;
    private Date DateLoan;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member membre;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private LocalDate dateEmprunt;
    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateLoan() {
        return DateLoan;
    }

    public void setDateLoan(Date DateLoan) {
        this.DateLoan = DateLoan;
    }

    public Member getMembre() {
        return membre;
    }

    public void setMembre(Member membre) {
        this.membre = membre;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(LocalDate dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }


    public void setMember(Member membre) {
    }
}
