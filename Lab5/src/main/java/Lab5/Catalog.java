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
public class Catalog {
    private String name;
    private String path;
    private List<Document> documents = new ArrayList<>();
    
    public Catalog(){}
    public Catalog(String newName, String newPath){
        this.name = newName;
        this.path = newPath;
    }
    
    public String getName(){
        return name;
    }
    
    public String getPath(){
        return path;
    }
    
    public void setName(String newName){
        this.name = newName;
    }
    
    public void setPath(String newPath){
        this.path = newPath;
    }
    
    public Document findById(String id) {
        return documents.stream()
        .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }
    
    public void add(Document doc) {
        documents.add(doc);
    }

    public String toString(){
        return name;
    }
}
