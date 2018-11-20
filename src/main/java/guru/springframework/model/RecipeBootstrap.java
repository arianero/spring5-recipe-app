package guru.springframework.model;


import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;

    public RecipeBootstrap(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>(2);

        //get UOMs
        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");

        if(!eachUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found");
        }


        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        if(!tableSpoonUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found");
        }


        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        if(!teaSpoonUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found");
        }


        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");

        if(!dashUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found");
        }


        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");

        if(!pintUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> cupsUomOptional = unitOfMeasureRepository.findByDescription("Cup");

        if(!pintUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found");
        }


        //get optionals
        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tableSpoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure teaSpoonUom = teaSpoonUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pintUom = pintUomOptional.get();
        UnitOfMeasure cupsUom = cupsUomOptional.get();




        //get Categories
        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

        if(!americanCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category Not Found");
        }

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");

        if(!americanCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category Not Found");
        }

        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();

        //Yummy Guac
        Recipe perfectGuacamole = new Recipe();
        perfectGuacamole.setDescription("Guacamole");
        perfectGuacamole.setPrepTime(10);
        perfectGuacamole.setCookTime(10);
        perfectGuacamole.setServings(3);
        perfectGuacamole.setSource("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        perfectGuacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        perfectGuacamole.setDirections("?");

        recipes.add(perfectGuacamole);

        Recipe spicyGrilledChickenTacos = new Recipe();
        spicyGrilledChickenTacos.setDescription("Spicy Grilled Chicken Tacos");
        spicyGrilledChickenTacos.setPrepTime(20);
        spicyGrilledChickenTacos.setCookTime(20);
        spicyGrilledChickenTacos.setServings(5);
        spicyGrilledChickenTacos.setSource("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        spicyGrilledChickenTacos.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        spicyGrilledChickenTacos.setDirections("?");

        recipes.add(spicyGrilledChickenTacos);

        return recipes;

    }

//    public void setUp() {
//        Recipe perfectGuacamole = new Recipe();
//        perfectGuacamole.setDescription("Guacamole");
//        perfectGuacamole.setPrepTime(10);
//        perfectGuacamole.setCookTime(10);
//        perfectGuacamole.setServings(3);
//        perfectGuacamole.setSource("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
//        perfectGuacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
//        perfectGuacamole.setDirections("?");
//
//        recipeRepository.save(perfectGuacamole);
//
//        Recipe spicyGrilledChickenTacos = new Recipe();
//        spicyGrilledChickenTacos.setDescription("Spicy Grilled Chicken Tacos");
//        spicyGrilledChickenTacos.setPrepTime(20);
//        spicyGrilledChickenTacos.setCookTime(20);
//        spicyGrilledChickenTacos.setServings(5);
//        spicyGrilledChickenTacos.setSource("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
//        spicyGrilledChickenTacos.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
//        spicyGrilledChickenTacos.setDirections("?");
//
//        recipeRepository.save(spicyGrilledChickenTacos);
//    }
}
