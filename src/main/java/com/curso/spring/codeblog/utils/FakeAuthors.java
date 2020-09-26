package com.curso.spring.codeblog.utils;


import com.curso.spring.codeblog.entities.Article;
import com.curso.spring.codeblog.entities.Author;
import com.curso.spring.codeblog.repositories.ArticleRepository;
import com.curso.spring.codeblog.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class FakeAuthors {

    @Autowired(required = true)
    AuthorRepository authorRepository;

    @Autowired(required = true)
    ArticleRepository articleRepository;

  //@PostConstruct
    public void run() {
        Author author = new Author();
        author.setName("rodrigo");
        author.setEmail("rodrigo@email.com");

        List<Author> authorList = new ArrayList<Author>();
        authorList.add(author);

        for (Author a:
             authorList) {
            authorRepository.save(a);
        }
    }


    @PostConstruct
    public void createArticles() {

        List<Article> articleList = new ArrayList<Article>();

        Article article = new Article();
        article.setTitle("artigo");
        article.setBody("corpo do artigo");
        article.setAuthor("rodrigo dias noronha");
        article.setDate(LocalDate.now());

        Article article1 = new Article();
        article1.setTitle("artigo 2");
        article1.setBody("body");
        article1.setDate(LocalDate.now());
        article1.setAuthor("rodrigo dias noronha");

        articleList.add(article);
        articleList.add(article1);

        for (Article a: articleList
             ) {
            articleRepository.save(a);
        }
    }
}
