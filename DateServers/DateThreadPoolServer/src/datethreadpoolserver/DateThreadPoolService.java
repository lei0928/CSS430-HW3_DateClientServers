/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datethreadpoolserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author rezan
 */
public class DateThreadPoolService extends Thread {
    
    private Socket client;
    
    
    public DateThreadPoolService(Socket client) {
        this.client = client;
    }
    
    
    public void run() {
        try {
            PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
            
            // write the Date to the socket
            pout.println(new java.util.Date().toString());
            
            // close the socket and exit
            client.close();
            System.out.println(
                    "Client Disconnected."
            );
         
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }
    
}
