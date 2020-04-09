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
    private Runnable[] players = {new Player("Andrei", this), new Player("Andrei", this), new Player("Denis", this), new Player("Diana", this)};
    private final int numberOfTokens;
    private int numberOfPlayers=0;
    
    public Game(int number1, String ... playersName){
        numberOfTokens=number1;
        for(String n : playersName) {   
             this.players[numberOfPlayers] = new Player(n, this);  
             numberOfPlayers++;
         } 
        this.board=new Board(this.numberOfTokens, this);
        for(int i=0; i<numberOfPlayers; i++){
            new Thread(players[i]).start();
        }
    }  
}
