package com.example.devopsproject.models;

import javax.persistence.*;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "Author_id", nullable = true)
    private Author author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author(String name) {
        this.name = name;
    }
    public Author(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Author(Long id, String name, Author author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
    public Author() {
    }


}
