package com.example.tacocloudapi.Database;
import com.example.tacocloudapi.Model.Ingredient;
import com.example.tacocloudapi.Repositories.IngredientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration // chạy đầu tiên

public class CreateDb {
    private static final Logger logger = LoggerFactory.getLogger(CreateDb.class);

    @Bean
    CommandLineRunner initDatabase(IngredientRepository ingredientRepository) {
        return args -> {
            Ingredient productA = new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN);
            Ingredient productB = new Ingredient("CHED ", "Cheddar",Ingredient.Type.CHEESE );
            Ingredient productC = new Ingredient("COTO","Corn Tortilla",Ingredient.Type.WRAP);
            Ingredient productD= new Ingredient("JACK", "Monterrey Jack",Ingredient.Type.CHEESE);
            Ingredient productE = new Ingredient("TMTO","Diced Tomatoes",Ingredient.Type.VEGGIES);
            logger.info("insert data" + ingredientRepository.save(productA));
            logger.info("insert data" + ingredientRepository.save(productB));
            logger.info("insert data" + ingredientRepository.save(productC));
            logger.info("insert data" + ingredientRepository.save(productD));
            logger.info("insert data" + ingredientRepository.save(productE));
        };
    }
}