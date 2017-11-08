/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dateseparatethreadserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author rezan
 */
public class DateSeparateThreadServer {

    private final static int PORT_NUMBER = 6013;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
            
            // now listen for connections 
            System.out.println("Waiting for clients to connect...");

            while (true) {
                Socket client = serverSocket.accept();
                System.out.println(
                        "Client Connected from " + client.getLocalAddress()
                );

                DateSeparateThreadService dateService = 
                        new DateSeparateThreadService(client);

                Thread thread = new Thread(dateService);
                thread.start();
        }
        
        
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        
 
        
    }
    
}
