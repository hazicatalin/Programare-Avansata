/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Lab8.Database;
import java.sql.ResultSet;

/**
 *
 * @author Hazi Catalin
 */
public class ArtistController {
    private Database db=new Database();
    private String sql;
    private ResultSet rs;
    
    public ArtistController(){}
    
    public ResultSet findByName(String name){
        sql = "SELECT * FROM artists where name='"+name+"'";
        rs=db.getArtist(sql);
        return rs;
    }
    
    public void create(String name, String country){
        sql="insert into artists(name, country) values ("+name+", "+country+")";
        db.addArtist(sql);
    }
    
}
