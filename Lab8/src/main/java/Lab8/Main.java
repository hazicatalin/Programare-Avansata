/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab8;

import java.sql.ResultSet;
import DAO.*;

/**
 *
 * @author Hazi Catalin
 */
public class Main {
     public static void main(String[] args) {
         
         ResultSet rs;
         AlbumController album=new AlbumController();
         ArtistController artist=new ArtistController();
         
         artist.create("Hazi", "Romania");
         album.create("First Album", 1, 1);
         
         rs=artist.findByName("hazi");
         System.out.println(rs); 
       
    }
    
}
