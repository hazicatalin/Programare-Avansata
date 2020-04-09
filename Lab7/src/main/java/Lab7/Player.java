/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab7;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public synchronized void run() {
       try{
           Thread.sleep(1000);
           extractedToken = joc.board.extractToken(number);
           System.out.println(Thread.currentThread().getName() + extractedToken );
       }catch(Exception ex){ System.err.println("Exception: " + ex);} 
    }
    
}
