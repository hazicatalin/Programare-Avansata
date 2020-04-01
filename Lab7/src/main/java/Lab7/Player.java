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
public class Player implements Runnable{
    private final String name;
    final Game joc;
    private int number;
    private Token extractedToken;

    public Player(String n, Game aThis) {
        this.joc=aThis;
        this.name=n;
    }
    
    @Override
    public void run() {
        extractedToken = joc.board.extractToken(number); //To change body of generated methods, choose Tools | Templates.
    } 
    
}
