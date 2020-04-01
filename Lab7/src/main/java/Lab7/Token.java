/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab7;

/**
 *
 * @author Hazi Catalin
 */
public class Token {
    private int number;
    public Token(int newNumber){
        this.number=newNumber;
    }
    public Token(){}
    public void setNumber(int newNumber){
        this.number=newNumber;
    }
    public int getNumber(){
        return number;
    }
    
}
