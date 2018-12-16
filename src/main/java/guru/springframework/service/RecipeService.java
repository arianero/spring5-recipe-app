package guru.springframework.service;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.model.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
