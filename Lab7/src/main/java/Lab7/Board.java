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
public class Board {
    private Token[] tokens;
    final Game joc;
    private Token token;
    private int tokenNumber=0;

    public Board(int numberOfTokens, Game aThis) {
        this.tokenNumber=numberOfTokens;
        this.joc=aThis;
        for(int i = 0; i< numberOfTokens; i++){
            tokens[i]= new Token(i);
        }
    }
    
    public void addToken(Token newToken){
        this.tokens[tokenNumber]=newToken;
        tokenNumber++;
    }
    public int getNumberOfTokens(){
        return tokenNumber;
    }
    public Token[] getTokens(){
        return tokens;
    }
    public Token extractToken(int number){
        this.tokenNumber--;
        this.token = this.tokens[number];
        this.tokens[number]=new Token(-1);
        return token;
    }
    
}
