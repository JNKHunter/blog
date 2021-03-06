package tech.eats.art.blog.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.eats.art.blog.model.Category;
import tech.eats.art.blog.service.CategoryService;

import java.util.List;

/**
 * Created by John on 11/15/16.
 */
@Controller
public class BlogController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/")
    public String listBlog(Model model) {
        return "blog/index";
    }
}
