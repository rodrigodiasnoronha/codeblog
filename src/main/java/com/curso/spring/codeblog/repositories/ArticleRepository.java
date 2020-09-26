package com.curso.spring.codeblog.repositories;

import com.curso.spring.codeblog.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
