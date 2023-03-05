/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Recipe;

/**
 *
 * @author lucas
 */
public class DaoRecipe {
    
    private Connection conn;
    
    public DaoRecipe(Connection c){
        this.conn = c;
    }
    
    public List<Recipe> listAllRecipes(){
        String str = "SELECT * FROM recipes";
        ResultSet rs;
        List<Recipe> list = new ArrayList();
        
        try {
            Statement stmt = this.conn.createStatement();
            rs = stmt.executeQuery(str);
            
            while (rs.next()){
                list.add(new Recipe(rs.getString("name"), 
                        rs.getString("description"), 
                        rs.getString("preparation_time"), 
                        rs.getString("cooking_time")));
                
            }
           for(Recipe u : list)
                u.displayRecipe();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
      
    public Recipe seeRecipe(String name){
        String str = "SELECT * FROM recipes WHERE name LIKE '%" + name + "%'";
        ResultSet rs;
        try {
            Statement stmt = this.conn.createStatement();
            rs = stmt.executeQuery(str);

            if (rs.next())
                return new Recipe(rs.getString("name"),
                    rs.getString("description"),
                    rs.getString("cooking_time"),  
                    rs.getString("preparation_time"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
   
    public boolean addRecipe(Recipe recipe) {
        String query = "INSERT INTO recipes (name, description, cooking_time, preparation_time) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, recipe.getName());
            ps.setString(2, recipe.getDescription());
            ps.setString(3, recipe.getCookingTime());
            ps.setString(4, recipe.getPreparationTime());
            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            System.out.println("Error while adding recipe: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean updateRecipe(Recipe recipe) {
        String query = "UPDATE recipes SET name = ?, description = ?, cooking_time = ?, preparation_time = ? WHERE name = ?";
        System.out.println(query);
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, recipe.getName());
            ps.setString(2, recipe.getDescription());
            ps.setString(3, recipe.getCookingTime());
            ps.setString(4, recipe.getPreparationTime());
            ps.setString(5, recipe.getName());
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            System.out.println("Error while updating recipe: " + ex.getMessage());
            return false;
        }
    }

    public boolean deleteRecipe(String name) {
        String query = "DELETE FROM recipes WHERE name LIKE ?";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            System.out.println("Error while deleting recipe: " + ex.getMessage());
            return false;
        }
    }

    public Connection getConn() {
        return this.conn;
    }
}
