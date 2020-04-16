/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Hazi Catalin
 */
public class Database {
    
   ResultSet rs;
   private static Connection con=null;
   Statement stmt=null;
   private String url="jdbc:oracle:thin:@localhost:1521:xe";  
   public Database() {
       try{
        con = DriverManager.getConnection(url, "dba1", "sql");
        stmt = con.createStatement();
       } catch(SQLException e) { System.err.println("Cannot connect to DB: " + e);}
   }

   public static Connection getConnection() {
      return con;
   }
   public void closeConnection(){
       try{
           con.close();
       }catch(SQLException e) { System.err.println("Cannot close the DB: " + e);}
   }
   
   public void addArtist(String sql){
       try{
        stmt.execute(sql);
       }catch(SQLException e) { System.err.println("Cannot execute comand " + e);}
   }
   
   public void addAlbum(String sql){
       try{
        stmt.execute(sql);
       }catch(SQLException e) { System.err.println("Cannot execute comand " + e);}
   }
   
   public ResultSet getArtist(String sql){
       try{
        rs = stmt.executeQuery(sql);
       }catch(SQLException e) { System.err.println("Cannot execute comand " + e);}
       return rs;
   }
   
   public ResultSet getAlbum(String sql){
       try{
        rs = stmt.executeQuery(sql);
       }catch(SQLException e) { System.err.println("Cannot execute comand " + e);}
       return rs;
   }
    
}
