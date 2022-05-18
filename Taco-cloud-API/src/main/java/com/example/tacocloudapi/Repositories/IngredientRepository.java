package com.example.tacocloudapi.Repositories;

import com.example.tacocloudapi.Model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient,String> {

}

