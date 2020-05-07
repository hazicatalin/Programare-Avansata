/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * @author Hazi Catalin
 */
public class Player {
    private int id;
    private String name;
    public Player(){
        this.name = "noName";
    }
    public Player(String newName, int id){
        this.name = newName;
        this.id = id;
    }
    public void setName(String newName){
        this.name = newName;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    
}
