package com.curso.spring.codeblog.controllers;


import com.curso.spring.codeblog.entities.Article;
import com.curso.spring.codeblog.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ArticleController {


    @Autowired
    ArticleService articleService;


    @RequestMapping(path = "/articles", method = RequestMethod.GET)
    public ModelAndView getArticles() {

        List<Article> articleList = articleService.listAll();
        ModelAndView modelAndView = new ModelAndView("list_articles");
        modelAndView.addObject("articles", articleList);

        return modelAndView;
    }

    @RequestMapping(path = "/articles/{id}", method = RequestMethod.GET)
    public ModelAndView getArticleDetails(@PathVariable("id") Long id) {

        Article article = articleService.getById(id);

        ModelAndView modelAndView = new ModelAndView("show_article");
        modelAndView.addObject("article", article);

        return modelAndView;
    }


    @RequestMapping(path = "/articles/create", method = RequestMethod.GET)
    public ModelAndView getArticleForm() {
        ModelAndView modelAndView = new ModelAndView("createArticle");
        return modelAndView;
    }


    @RequestMapping(path = "/articles/create", method = RequestMethod.POST)
    public String saveArticle(@Validated Article article, BindingResult result, RedirectAttributes redirectAttributes) { // valida os dados do artigo (tipo o validator do laravel e adonis)
        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("mensagem", "Verifique se os campos foram preenchidos");
            return "redirect:/createArticle";
        }

        article.setDate(LocalDate.now());
        articleService.create(article);

        return "redirect:/articles";
    }

}
