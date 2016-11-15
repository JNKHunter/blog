package tech.eats.art.blog.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by John on 11/15/16.
 */
@Controller
public class BlogController {

    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping("/")
    public String listBlog(Model model){
        return "blog/index";
    }

    @RequestMapping("/categories")
    public String listCategories(Model model){
        return "blog/categories";
    }
}
