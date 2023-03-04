/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.util.Scanner;

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
                        + "\n  - to quit the program, type \"exit\"");
        Scanner scan = new Scanner(System.in);
        String inputUser = "";
        while (!inputUser.equals("exit")) {
            inputUser = scan.nextLine();
            switch (inputUser) {
                case "1" -> listAllRecipes();
                case "2" -> seeRecipe();     
                case "3" -> addRecipe();
                case "4" -> modifyRecipe();
                case "5" -> deleteRecipe();
                case "6" -> back();
                default -> System.out.println("rien du tout");
            }
        }
    }
    
    public void listAllRecipes(){
        
    }
    
    public void seeRecipe(){
        
    }
    
    public void addRecipe(){
        
    }
    
    public void modifyRecipe(){
        
    }
    
    public void deleteRecipe(){
        
    }
    public void back(){
        ViewMain returnMain = new ViewMain();
    }
}
