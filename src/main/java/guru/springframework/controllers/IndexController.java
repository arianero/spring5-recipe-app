package guru.springframework.controllers;

import guru.springframework.model.Category;
import guru.springframework.model.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import guru.springframework.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {
    @Autowired
    private RecipeService recipeService;

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
//        recipeService.sth(model);
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
