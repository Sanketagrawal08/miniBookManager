package com.example.abhi0.helloa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.abhi0.helloa.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
        
}   
