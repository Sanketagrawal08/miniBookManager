package com.example.abhi0.helloa.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.abhi0.helloa.Entity.Book;
import com.example.abhi0.helloa.service.BookService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin(origins="http://localhost:5173")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;
    
    @PostMapping("/addbook")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

   
    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PutMapping("update/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
       return bookService.updateBook(id, book);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Book book){
        bookService.delete(book.getId());
    }

}