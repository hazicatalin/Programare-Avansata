/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Hazi Catalin
 */
public class Resident {
    private String name;
    public Resident(){}
    public Resident(String newName){
        this.name=newName;
    }
    public void setName(String newName){
        this.name=newName;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        return name;
    }
}
