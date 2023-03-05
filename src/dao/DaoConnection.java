/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import com.mysql.cj.jdbc.Driver;
/**
 *
 * @author lucas
 */
public class DaoConnection {
    
    private Connection conn;

    // constructor
    public DaoConnection() {      
        try {
            Class.forName ("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?useSSL=false", "root", "root");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    // getter
    public Connection getConn() {
        return this.conn;
    }
    
    
    public void execute(String s){
        Statement stmt;
        
        try {
            stmt = this.conn.createStatement();
            stmt.executeUpdate(s);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void createDatabase(){
            String str1 = "CREATE DATABASE IF NOT EXISTS cookbook CHARACTER SET utf8;";
            String str2 = "use cookbook";
            System.out.println("Creating database");
            this.execute(str1);
            this.execute(str2);
            System.out.println("Database have been created with succes");
    }
    
    public void createTables(){
        String str1 = "CREATE TABLE IF NOT EXISTS recipes ("
                + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                + "name VARCHAR(255) NOT NULL, "
                + "description LONGTEXT NOT NULL, "
                + "cooking_time Varchar(30) NOT NULL, "
                + "preparation_time Varchar (30) NOT NULL )";
        
        String str2 = "CREATE TABLE IF NOT EXISTS ingredients ("
                    + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                    + "name VARCHAR(255) NOT NULL, "
                    + "quantity INT NOT NULL,"
                    + "unit VARCHAR(10) NOT NULL , "
                    + "recipes_id INT NOT NULL, "
                    + "FOREIGN KEY (recipes_id) REFERENCES recipes(id) ON DELETE CASCADE )";
                    
        
        System.out.println("Creating Recipes table");
        this.execute(str1);
        System.out.println("Table recipes have been created with success");
        
        System.out.println("Creating Ingredients table");
        this.execute(str2);
        System.out.println("Table Ingredients have been created with success");
    }
}
