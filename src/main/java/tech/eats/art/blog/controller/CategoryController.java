package tech.eats.art.blog.controller;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value="/categories", method = RequestMethod.POST)
    public String addCategory(Category category){
        //Add category if valid data was received
        categoryService.save(category);
        //Redirect browser to /categories
        return "redirect:/categories";
    }


}