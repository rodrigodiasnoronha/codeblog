package com.curso.spring.codeblog.services.interfaces;

import com.curso.spring.codeblog.entities.Author;

import java.util.List;

public interface AuthorServiceInterface {
    List<Author> listAll();
    Author create(Author author);
}
