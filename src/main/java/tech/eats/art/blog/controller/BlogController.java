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
        //We return a LocalSessionFactoryBean which implements the FactoryBean interface.
        //By including a method annotated with @Bean whose return value is of type LocalSessionFactoryBean,
        // a SessionFactory is now a candidate for autowiring
        Session session = sessionFactory.openSession();
        List<Category> categories = session.createCriteria(Category.class).list();
        session.close();
        model.addAttribute("categories", categories);
        return "blog/categories";
    }
}
