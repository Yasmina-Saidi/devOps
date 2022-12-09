package com.example.devopsproject.controllers;
import com.example.devopsproject.models.Author;
import com.example.devopsproject.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@CrossOrigin(origins = "*")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @GetMapping("/")
    public List<Author> getAuthors() throws Exception
    {
        List<Author> authorsList = this.authorService.getAuthors();
        return authorsList;
    }

    @PostMapping("/")
    public Author createNewAuthor(@RequestBody Author newAuthor) throws Exception
    {
    	Author author = this.authorService.createAuthor(newAuthor);
        return author;
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable("id") Long id) throws Exception
    {
        Author author = this.authorService.getAuthorById(id);
        return author;
    }
}
