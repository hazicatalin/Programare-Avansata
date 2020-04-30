/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Hazi Catalin
 */
public class ClientThread extends Thread {
    private Socket socket = null ;
    String request="a";
    int i=0;
    public ClientThread (Socket socket) { this.socket = socket ; }
    public void run () {
        try {
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
            while(!(request.equals("exit")))
            {
                request = in.readLine();
                // Send the response to the oputput stream: server → client
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                if(request.equals("stop"))
                {
                String raspuns = "Server stopped";
                out.println(raspuns);
                out.flush();
                break;
                }
                else{
                String raspuns = "Server received the request ... " + request;
                out.println(raspuns);
                out.flush();
                }
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println (e); }
        }
    }
}
