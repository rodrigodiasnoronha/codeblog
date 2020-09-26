package com.curso.spring.codeblog.repositories;

import com.curso.spring.codeblog.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {

}
