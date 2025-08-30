package com.example.abhi0.helloa.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity

public class Book {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int Id;


    private String BookTitle;

    @OneToOne(cascade=CascadeType.ALL)
    //parents ke operation child par bhi apply ho iske liye cascasde laagate he 
    @JsonManagedReference
    private Author author;

    public Book(int Id, String BookTitle, Author author) {
        this.Id = Id;
        this.BookTitle = BookTitle;
        this.author = author;
    }

    public Book() {
    // default constructor
}


    @Override
    public String toString() {
        return "{" +
            " Id='" + getId() + "'" +
            ", BookTitle='" + getBookTitle() + "'" +
            ", author='" + getAuthor() + "'" +
            "}";
    }
   

    public int getId() {
        return this.Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getBookTitle() {
        return this.BookTitle;
    }

    public void setBookTitle(String BookTitle) {
        this.BookTitle = BookTitle;
    }

     public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    
}
