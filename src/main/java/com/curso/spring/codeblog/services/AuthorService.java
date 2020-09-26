package com.curso.spring.codeblog.services;

import com.curso.spring.codeblog.entities.Author;
import com.curso.spring.codeblog.repositories.AuthorRepository;
import com.curso.spring.codeblog.services.interfaces.AuthorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements AuthorServiceInterface {

    @Autowired(required = true)
    AuthorRepository authorRepository;

    @Override
    public List<Author> listAll() {
        return authorRepository.findAll();
    }

    public Author create(Author author) {
        return authorRepository.save(author);
    }
}
