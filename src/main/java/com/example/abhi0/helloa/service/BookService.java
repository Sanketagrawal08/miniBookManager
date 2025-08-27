package com.example.abhi0.helloa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.abhi0.helloa.Entity.Book;
import com.example.abhi0.helloa.dao.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book booktoSave) {
        Book book = bookRepository.save(booktoSave);
        return book;
    }

    public List<Book> getAllBooks() {
        List<Book> allb = bookRepository.findAll();
        return allb;
    }

    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(int id, Book book) {
        Optional<Book> opt = bookRepository.findById(id);

        Book existing = opt.get();

        existing.setBookTitle(book.getBookTitle());
        existing.setAuthorName(book.getAuthorName());

        return bookRepository.save(existing);
    }
}
