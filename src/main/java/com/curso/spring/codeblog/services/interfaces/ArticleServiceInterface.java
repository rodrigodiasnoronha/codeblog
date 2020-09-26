package com.curso.spring.codeblog.services.interfaces;

import com.curso.spring.codeblog.entities.Article;

import java.util.List;

public interface ArticleServiceInterface {
    List<Article> listAll();
    Article getById(Long id);
    Article create(Article article);
}
