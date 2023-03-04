/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import cookbook.model.Ingredient;
import java.util.List;

/**
 *
 * @author lucas
 */
public class Recipe {
    private int id;
    private String name;
    private List<Ingredient> ingredients;
    private String description;
    private String cookingTime;
    private String preparationTime;
    
    // constructor
    public Recipe(String name, List<Ingredient> ingredients, String description, String cookingTime, String preparationTime) {
        this.name = name;
        this.ingredients = ingredients;
        this.description = description;
        this.cookingTime = cookingTime;
        this.preparationTime = preparationTime;
    }
    
    // getters
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<Ingredient> getIngredients() {
        return this.ingredients;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public String getCookingTime() {
        return this.cookingTime;
    }

    public String getPreparationTime() {
        return this.preparationTime;
    }
    
    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    public void setCookingTime(String cookingTime) {
        this.cookingTime = cookingTime;
    }

    public void setPreparation(String preparationTime) {
        this.preparationTime = preparationTime;
    }
    
    public void displayRecipe(){
        System.out.println("""
                Recette : 
                - ID : """ + this.id + "\n" 
                + "Title :  " + this.name + "\n" 
                + "Ingredients : " + this.ingredients + "\n" 
                + "Description : " + this.description + "\n" 
                + "Cooking time : " + this.cookingTime + "\n" 
                + "preparation time : " + this.preparationTime
        );
    }
    
}
