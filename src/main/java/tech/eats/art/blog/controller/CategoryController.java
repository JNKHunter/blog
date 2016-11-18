package tech.eats.art.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.eats.art.blog.model.Category;
import tech.eats.art.blog.service.CategoryService;

import java.util.List;

/**
 * Created by John on 11/18/16.
 */
@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @SuppressWarnings("unchecked")
    @RequestMapping("/categories")
    public String listCategories(Model model) {

        List<Category> categories =  categoryService.findAll();

        model.addAttribute("categories", categories);
        return "blog/categories";
    }

    public String addCategory(){
        //Add category if valid data was received

        //Redirect browser to /categories

        return null;
    }


}
