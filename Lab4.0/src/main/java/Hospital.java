/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Hazi Catalin
 */
public class Hospital implements Comparable<Hospital>{
    private String name;
    private int capacity;
    public Hospital(){}
    public Hospital(String newName){
        this.name=newName;
    }
    public Hospital(int newCapacity){
        this.capacity=newCapacity;
    }
    public Hospital(String newName, int newCapacity){
        this.capacity=newCapacity;
        this.name=newName;
    }
    public String getName(){
        return name;
    }
    public int getCapacity(){
        return capacity;
    }
    public void setName(String newName){
        this.name=newName;
    }
    public void setCapacity(int newCapacity){
        this.capacity=newCapacity;
    }
    @Override
    public String toString(){
        return name;
    }

    @Override
    public int compareTo(Hospital hospital2) {
        if(this.getCapacity() > hospital2.getCapacity())
            return 1;
        else
            return -1;
    }
    
}
