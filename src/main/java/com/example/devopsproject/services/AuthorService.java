package com.example.devopsproject.services;
import com.example.devopsproject.models.Author;
import com.example.devopsproject.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public List<Author> getAuthors() throws Exception {
        return this.authorRepository.findAll();
    }

    public Author createAuthor(Author author) throws Exception {
        return this.authorRepository.save(author);
    }

    public Author getAuthorById(Long authorId) throws Exception {

        Optional<Author> author = this.authorRepository.findById(authorId);

        return author.orElseThrow(()-> new Exception("Author not found"));
    }
}
