package com.curso.spring.codeblog.controllers;

import com.curso.spring.codeblog.entities.Author;
import com.curso.spring.codeblog.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired(required = true)
    AuthorService authorService;

    @RequestMapping(path = "/authors", method = RequestMethod.GET)
    public ModelAndView getAuthors() {
        List<Author> authorList = authorService.listAll();

        ModelAndView modelAndView = new ModelAndView("list_authors");
        modelAndView.addObject("authors", authorList);

        return modelAndView;
    }


    @RequestMapping(path = "/authors/create", method = RequestMethod.POST)
    public String createAuthor(@Validated Author author, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "redirect:/authors";
        }
        Author authorCreated = authorService.create(author);

        return "redirect:/authors";
    }
}

