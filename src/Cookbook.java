/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import dao.DaoConnection;
import views.ViewMain;
import views.ViewRecipe;

/**
 *
 * @author lucas
 */
public class Cookbook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DaoConnection connection = new DaoConnection();
        connection.createDatabase();
        connection.createTables();
        System.out.println("\n" + "\n" + "\n");
        ViewMain mainMenu = new ViewMain();
        ViewRecipe recipeMenu = new ViewRecipe();
    }
}
