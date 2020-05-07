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
public class Game {
    private Player player1, player2;
    private int[][] board = new int[15][15];
    
    public Game(){
        player1 = new Player();
        player2 = new Player();
        for(int i=0; i<15; i++)
            for(int j=0; j<15; j++)
                board[i][j]=0;
    }
    
    public Game(String name1, String name2, int id1, int id2){
        player1 = new Player(name1, id1);
        player2 = new Player(name2, id2);
        for(int i=0; i<15; i++)
            for(int j=0; j<15; j++)
                board[i][j]=0;
    }
    
}
