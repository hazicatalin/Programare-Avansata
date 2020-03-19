/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;

import java.util.*;

/**
 *
 * @author Hazi Catalin
 */
public class Document {
    private String id;
    private String name;
    private String location;
    private Map<String, Object> tags = new HashMap<>();
    
    public Document(){}
    public Document(String newName, String newId, String newLocation){
        this.location = newLocation;
        this.id = newId;
        this.name = newName;
    }
    
    public String getName(){
        return name;
    }
    
    public String getId(){
        return id;
    }
    
    public String getLocation(){
        return location;
    }
    
    public void setName(String newName){
        this.name = newName;
    }
    
    public void setId(String newId){
        this.id = newId;
    }
    
    public void setLocation(String newLocation){
        this.location = newLocation;
    }
    
    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

    public String toString(){
        return name;
    }
}
