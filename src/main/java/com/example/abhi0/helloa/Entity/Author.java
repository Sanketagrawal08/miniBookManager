package com.example.abhi0.helloa.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GenerationType;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)
    private int authorId;
    
    private String firstName;
    private String lastName;
    private String language;

    @OneToOne(mappedBy= "author")
    @JsonBackReference
    private Book book;

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author() {
    }

    public Author(int authorId, String firstName, String lastName, String language) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.language = language;
    }

    public int getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Author authorId(int authorId) {
        setAuthorId(authorId);
        return this;
    }

    public Author firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public Author lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public Author language(String language) {
        setLanguage(language);
        return this;
    }

    

    @Override
    public String toString() {
        return "{" +
            " authorId='" + getAuthorId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", language='" + getLanguage() + "'" +
            "}";
    }

}
