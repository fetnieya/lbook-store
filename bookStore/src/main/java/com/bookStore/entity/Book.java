package com.bookStore.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String author;
	private boolean isAvailable;
	public Book(int id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;

	}
	public Book() {
		super();

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}


	@OneToMany(mappedBy = "book")
	private List<Reservation> reservation;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;
	@OneToMany(mappedBy = "book")
	private Set<Loan> loans = new HashSet<>();

}
