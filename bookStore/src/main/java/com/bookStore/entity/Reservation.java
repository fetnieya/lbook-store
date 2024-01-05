package com.bookStore.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "RESERVATION")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id") // Assuming the column in 'Book' table is 'book_id'
    private Book book;

    @ManyToOne
    @JoinColumn(name = "member_id") // Assuming you have a Member entity
    private Member member;

    private LocalDate reservationDate;


}
