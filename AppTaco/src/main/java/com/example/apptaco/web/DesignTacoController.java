package com.example.apptaco.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



import com.example.apptaco.Ingredient;
import com.example.apptaco.Taco;
import com.example.apptaco.Ingredient.Type;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.client.RestTemplate;


@Controller
@RequestMapping("/design")
public class DesignTacoController {
	private final RestTemplate rest = new RestTemplate();
	
	@ModelAttribute
	public void addIngredientsToModel(Model model) {
		List<Ingredient> ingredients = Arrays.asList(rest.getForObject("http://localhost:8080/ingredients",Ingredient[].class));
				Type[] types = Type.values();
				for (Type type : types) {
					model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients,type));
				}
	}
	@GetMapping 
	public String showDesinForm(Model model) {
		model.addAttribute("taco", new Taco());
		return "design";
	}
	
	public List<Ingredient> filterByType(List <Ingredient> ingredients, Type type){
		List <Ingredient> ingList = new ArrayList<>();
		for(Ingredient ingredient : ingredients) {
			if(ingredient.getType().equals(type)) {
				ingList.add(ingredient);
			}
		}
		return ingList;
	}
	
	@PostMapping
	public String processDesign(@RequestParam("ingredients") String
										ingredientIds, @RequestParam("name") String name) {
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		for (String ingredientId : ingredientIds.split(",")) {
			Ingredient ingredient = rest.getForObject("http://localhost:8080/ingredients/{id}",Ingredient.class, ingredientId);
					ingredients.add(ingredient);
		}
		Taco taco = new Taco();
		taco.setName(name);
		taco.setIngredients(ingredients);
		System.out.println(taco);
		rest.postForObject("http://localhost:8080/design", taco, Taco.class);
		return "redirect:/orders/current";
	}


}
