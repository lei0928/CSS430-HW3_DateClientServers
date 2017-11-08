/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dateserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author rezan
 */
public class DateServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try {
            ServerSocket sock = new ServerSocket(6013);
            // now listen for connections 
            while (true) {
                   Socket client = sock.accept();
                   PrintWriter pout = new
                   PrintWriter(client.getOutputStream(), true);
                   // write the Date to the socket
                   pout.println(new java.util.Date().toString());
                   // close the socket and resume
                   // listening for connections
                   client.close();
            }
        }
        catch (IOException ioe) { 
            System.err.println(ioe);
        }
        
        
    }
    
}
