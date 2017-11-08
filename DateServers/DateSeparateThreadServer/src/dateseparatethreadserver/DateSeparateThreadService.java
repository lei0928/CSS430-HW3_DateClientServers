/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dateseparatethreadserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author rezan
 */
public class DateSeparateThreadService implements Runnable {
    
    private Socket client;
    
    public DateSeparateThreadService(Socket client) {
        this.client = client;
    }
    
    
    public void run() {
        try {
            try {
                   PrintWriter pout = 
                           new PrintWriter(client.getOutputStream(), true);

                   // write the Date to the socket
                   pout.println(new java.util.Date().toString());
                
            } finally {
                // close the socket and resume
                // listening for connections
                client.close();
                System.out.println(
                    "Client Disconnected."
                );                
            }
        }
        catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }
    
}
