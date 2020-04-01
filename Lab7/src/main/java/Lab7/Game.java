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
public class Game {
    Board board;
    private Player [] players;
    private final int  numberOfTokens;
    private int i=1;
    
    public Game(int number1, String ... playersName){
        this.numberOfTokens=number1;
        for(String n : playersName) {   
             this.players[i]= new Player(n, this);  
             i++;
         } 
        this.board=new Board(this.numberOfTokens, this);
    }
    
    
    
}
