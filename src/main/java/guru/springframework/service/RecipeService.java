package guru.springframework.service;

import guru.springframework.model.Recipe;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Set;

public interface RecipeService {
    List sth(Model model);

    ///////////////////////
    Set<Recipe> getRecipes();
}
