package tech.eats.art.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by John on 11/15/16.
 */
@Controller
public class BlogController {

    @RequestMapping("/")
    public String listBlog(Model model){
        return "blog/index";
    }
}
