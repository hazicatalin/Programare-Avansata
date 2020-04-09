/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab8;

import java.sql.*;

/**
 *
 * @author Hazi Catalin
 */
public class Database {
    
   private static Database connection = null;
   private Database() {
      // Exists only to defeat instantiation.
   }

   public static Database getConnection() {
      if(connection == null) {
         connection = new Database();
      }
      
      return connection;
   }
   public void closeConnection(){
       
   }
    
}
