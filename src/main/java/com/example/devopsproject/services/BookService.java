package com.example.devopsproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.devopsproject.models.Book;
import com.example.devopsproject.models.Author;
import com.example.devopsproject.repositories.BookRepository;
import com.example.devopsproject.repositories.AuthorRepository;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public Book createBook(Book book, Long authorId) throws Exception {

        Optional<Author> authorData = this.authorRepository.findById(authorId);
        Author author = authorData.orElseThrow(() -> new Exception("Author not found"));
        book.setAuthor(author);
        Book createdBook = this.bookRepository.save(book);
        return createdBook;
    }

    public List<Book> getAllBooks() throws Exception {
        List<Book> books = this.bookRepository.findAll();
        return books;
    }

    public Book getBookById(Long bookId) throws Exception {
        Optional<Book> bookData = this.bookRepository.findById(bookId);
        Book book = bookData.orElseThrow(()-> new Exception("Book not found"));
        return book;
    }
}
