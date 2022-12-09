package com.example.devopsproject.controllers;

import com.example.devopsproject.models.Book;
import com.example.devopsproject.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/")
    public List<Book>getBooks() throws Exception
    {
        List<Book> booksList = this.bookService.getAllBooks();
        return booksList;
    }

    @PostMapping("/{teacherId}")
    public Book createNewBook (
        @RequestBody Book newBook, 
        @PathVariable("authorId") Long authorId
    ) throws Exception
    {
        Book book = this.bookService.createBook(newBook, authorId);
        return book;
    }

    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable("bookId") Long bookId) throws Exception
    {
        Book book = this.bookService.getBookById(bookId);
        return book;
    }
}
