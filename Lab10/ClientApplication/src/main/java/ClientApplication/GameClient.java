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
        int i=0;
        String request="a";
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        try (
            Socket socket = new Socket(serverAddress, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader (
            new InputStreamReader(socket.getInputStream())) ) {
                // Send a request to the server
                while(true){
                    if(request.equals("exit"))
                        break;
                    i++;
                    System.out.println("Enter request: ");
                    request = sc.next();
                    out.println(request);
                    // Wait the response from the server ("Hello World!")
                    String response = in.readLine ();
                    System.out.println(response);
                    if(response.equals("Server stopped"))
                        break;
                }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
    
}
