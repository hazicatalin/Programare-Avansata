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
public class AlbumController {
    
    public AlbumController(){}
    
    private Database db=new Database();
    private String sql;
    private ResultSet rs;
    
    public ResultSet findByArtist(int artistId){
        sql = "SELECT * FROM album where artist_id="+artistId;
        rs=db.getAlbum(sql);
        return rs;
    }
    
    public void create(String name, int artistId, int releaseYear){
        sql="insert into albums(name, artist_id, release_year) values ("+name+", "+artistId+", "+releaseYear+")";
        db.addAlbum(sql);        
    }
    
}
