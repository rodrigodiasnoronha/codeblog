package com.curso.spring.codeblog.services;

import com.curso.spring.codeblog.entities.Article;
import com.curso.spring.codeblog.repositories.ArticleRepository;
import com.curso.spring.codeblog.services.interfaces.ArticleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService implements ArticleServiceInterface {

    @Autowired
    ArticleRepository articleRepository;


    public List<Article> listAll() {
        List<Article> articleList = articleRepository.findAll();
        return articleList;
    }

    public Article getById(Long id) {
        return articleRepository.findById(id).get();
    }

    public  Article create(Article article) {
        return articleRepository.save(article);
    }
}
