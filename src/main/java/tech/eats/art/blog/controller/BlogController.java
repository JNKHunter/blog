package tech.eats.art.blog.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.eats.art.blog.model.Category;

import java.util.List;

/**
 * Created by John on 11/15/16.
 */
@Controller
public class BlogController {

    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping("/")
    public String listBlog(Model model) {
        return "blog/index";
    }

    @SuppressWarnings("unchecked")
    @RequestMapping("/categories")
    public String listCategories(Model model) {
        Session session = sessionFactory.openSession();
        List<Category> categories = session.createCriteria(Category.class).list();
        model.addAttribute("categories", categories);
        return "blog/categories";
    }
}
