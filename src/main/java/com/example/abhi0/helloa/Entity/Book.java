package com.example.abhi0.helloa.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int Id;


    private String BookTitle;
    private String AuthorName;

    public Book(int Id, String BookTitle, String AuthorName) {
        this.Id = Id;
        this.BookTitle = BookTitle;
        this.AuthorName = AuthorName;
    }

    public Book() {
    // default constructor
}

    @Override
    public String toString() {
        return "{" +
            " Id='" + getId() + "'" +
            ", BookTitle='" + getBookTitle() + "'" +
            ", AuthorName='" + getAuthorName() + "'" +
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

    public String getAuthorName() {
        return this.AuthorName;
    }

    public void setAuthorName(String AuthorName) {
        this.AuthorName = AuthorName;
    }
    
}
