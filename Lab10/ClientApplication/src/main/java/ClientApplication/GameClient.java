/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author Hazi Catalin
 */
public class GameClient {
    public static void main (String[] args) throws IOException {
        Scanner sc =new Scanner(System.in);
        String request="a", matrice="a";
        int ok=0, k=0, a, b;
        int[][] table = new int [16][16];
        for(int i=0; i<=15; i++)
            for(int j=0; j<=15; j++)
            {
                if(i==0)
                    table[i][j]=j;
                else
                    if(j==0)
                        table[i][j]=i;
                        else
                            table[i][j]=0;
            }
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        try (
            Socket socket = new Socket(serverAddress, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader (
            new InputStreamReader(socket.getInputStream())) ) {
                // Send a request to the server
                while(true){
                    if(ok==1){
                        for(int i=0; i<=15; i++)
                        {
                            matrice=" ";
                            for(int j=0; j<=15; j++)
                            {
                                if(table[i][j]<10)
                                    matrice=matrice+String.valueOf(table[i][j])+ "| ";
                                else
                                    matrice=matrice+String.valueOf(table[i][j])+ "|";
                            }
                            System.out.println(matrice);
                        }
                        System.out.println("Enter yout choice:"); //trebuie introdusa linia si coloana unde vrem sa puem piatra(ex: 3,15)
                        request = sc.next();
                        if(request.equals("exit"))
                            break;
                        else 
                        {   String[] arrOfStr1 = request.split(",", 2);
                            a=Integer.parseInt(arrOfStr1[0]);
                            b=Integer.parseInt(arrOfStr1[1]);
                            if(table[a][b]==0 && a<=15 && a>=1 && b<=15 && b>=1){
                                table[a][b]=1;
                                out.println(request);
                                String response = in.readLine ();
                                if(response.equals("YOU WIN!") || response.equals("COMPUTER WINS!")){
                                    k=1;
                                    System.out.println(response);
                                }
                                else
                                    if(response.equals("Server stopped"))
                                        break;
                                    else{
                                        String[] arrOfStr2 = response.split(" ", 2);
                                        a=Integer.parseInt(arrOfStr2[0]);
                                        b=Integer.parseInt(arrOfStr2[1]);
                                        table[a][b]=2;
                                    }
                                
                            }
                        }
                    }
                    if(ok==0){
                        System.out.println("Enter request: ");
                        request = sc.next();
                        if(request.equals("exit"))
                        break;
                        if(request.equals("StartGame!"))
                            ok=1;
                        out.println(request);
                        // Wait the response from the server ("Hello World!")
                        String response = in.readLine ();
                        System.out.println(response);
                        if(response.equals("Server stopped"))
                            break;
                    }
                    if(k==1){
                        ok=0; k=0;
                        for(int i=1; i<=15; i++)
                            for(int j=1; j<=15; j++)
                                table[i][j]=0;
                    }
                }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
    
}
