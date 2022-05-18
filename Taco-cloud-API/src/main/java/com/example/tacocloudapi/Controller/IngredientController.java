package com.example.tacocloudapi.Controller;
import java.util.Optional;

import com.example.tacocloudapi.Model.Ingredient;
import com.example.tacocloudapi.Repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(path = "/ingredients", produces = "application/json")
@CrossOrigin(origins = "*")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepo;
    public IngredientController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }
    @GetMapping
    public Iterable<Ingredient> getAllIngredients() {
        return ingredientRepo.findAll();
    }

    @GetMapping("/{id}")
    public Ingredient ingredientById(@PathVariable("id") String id) {
        Optional<Ingredient> optIngredient = ingredientRepo.findById(id);
        return optIngredient.orElse(null);
    }
}
