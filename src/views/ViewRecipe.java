/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import dao.DaoConnection;
import dao.DaoRecipe;
import java.util.List;
import java.util.Scanner;
import model.Recipe;
/**
 *
 * @author lucas
 */
public class ViewRecipe {
    public ViewRecipe(){
        System.out.println("Welcome to your recipe book !");
        System.out.println("This recipe book allows you to see all your recipes, add recipes, modify them according to your wishes and delete them...");
        System.out.println("Please select an action from the list below : \n"
                        + "\n1 - See all my recipes"
                        + "\n2 - See a recipe"
                        + "\n3 - Add a recipe"
                        + "\n4 - Modify a recipe"
                        + "\n5 - Delete a recipe"
                        + "\n6  - Back"
                        + "\n  [X] to quit the program, type \"exit\"");
        Scanner scan = new Scanner(System.in);
        String inputUser = "";
        while (!inputUser.equals("exit")) {
            inputUser = scan.nextLine();
            switch (inputUser) {
                case "1" -> listAllRecipes();
                case "2" -> seeRecipe();     
                case "3" -> addRecipe();
                case "4" -> updateRecipe();
                case "5" -> deleteRecipe();
                case "6" -> back();
            }
        }
    }
        
    
    public void addRecipe(){
        DaoConnection connection = new DaoConnection();
        connection.execute("use cookbook");
        DaoRecipe daoRecipe = new DaoRecipe(connection.getConn());
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Creating new recipe : \n");
        System.out.println("---------------------------");
        System.out.println("Please enter the recipe name:");
        String name = scanner.nextLine();
        System.out.println("Please enter the recipe description:");
        String description = scanner.nextLine();
        System.out.println("Please enter the preparation time (in minutes):");
        String preparationTime = scanner.nextLine();
        System.out.println("Please enter the cooking time (in minutes):");
        String cookingTime = scanner.nextLine();

        Recipe recipe = new Recipe(name, description, cookingTime, preparationTime);   
        
        connection.execute("use cookbook");
        daoRecipe.addRecipe(recipe);
        System.out.println("Recipe have beean created with success !");
        
        back();
    }
    
    public void seeRecipe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the recipe you are looking for : ");
        String name = scanner.nextLine();
        DaoConnection connection = new DaoConnection();
        connection.execute("use cookbook");
        DaoRecipe daoRecipe = new DaoRecipe(connection.getConn());
        Recipe recipe = daoRecipe.seeRecipe(name);

        if (recipe != null) {
            recipe.displayRecipe();
        } else {
            System.out.println("Recipe not found !");
        }
        
        back();
    }
    
    public void listAllRecipes(){
        DaoConnection connection = new DaoConnection();
        connection.execute("use cookbook");
        DaoRecipe daoRecipe = new DaoRecipe(connection.getConn());
        
        List<Recipe> recipes = daoRecipe.listAllRecipes();
        for (Recipe recipe : recipes)
            recipe.displayRecipe();
        
        back();
    }
    
    public void updateRecipe(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the recipe you want to edit : ");
        String name = scanner.nextLine();
   
        DaoConnection connection = new DaoConnection();
        connection.execute("use cookbook");
        DaoRecipe daoRecipe = new DaoRecipe(connection.getConn());
        Recipe recipe = daoRecipe.seeRecipe(name);
        
        if (recipe != null) {
            recipe.displayRecipe();
            System.out.println("---------------------------");
            System.out.println("Enter a new name for the recipe (leave blank to keep the current name):");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                recipe.setName(newName);
            }
            System.out.println("Enter a new description for the recipe (leave blank to keep the current description):");
            String newDescription = scanner.nextLine();
            if (!newDescription.isEmpty()) {
                recipe.setDescription(newDescription);
            }
            System.out.println("Enter a new preparation time for the recipe (in minutes, leave blank to keep the current time):");
            String newPreparationTime = scanner.nextLine();
            if (!newPreparationTime.isEmpty()) {
                recipe.setPreparation(newPreparationTime);
            }
            System.out.println("Enter a new cooking time for the recipe (in minutes, leave blank to keep the current time):");
            String newCookingTime = scanner.nextLine();
            if (!newCookingTime.isEmpty()) {
                recipe.setCookingTime(newCookingTime);
            }

            daoRecipe.updateRecipe(recipe);
            System.out.println("Recipe have been updated with succes.");
            recipe.displayRecipe();
        } else {
            System.out.println("Recipe not found ! ");
        }
        back();
    }
    
    public void deleteRecipe(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the recipe you want to delete : ");
        String name = scanner.nextLine();
    
        DaoConnection connection = new DaoConnection();
        connection.execute("use cookbook");
        DaoRecipe daoRecipe = new DaoRecipe(connection.getConn());
        daoRecipe.deleteRecipe(name);
        System.out.println("Recipe have been deleted !");
        
        back();
    }
 
    public void back(){
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
            while (!userInput.equalsIgnoreCase("Y")){
                System.out.println("Do you want to go back? (Y/N)");
                userInput = scanner.nextLine();
            }
        ViewRecipe recipeMain = new ViewRecipe();
        System.out.println("Returning to the previous menu...");
    }
}
