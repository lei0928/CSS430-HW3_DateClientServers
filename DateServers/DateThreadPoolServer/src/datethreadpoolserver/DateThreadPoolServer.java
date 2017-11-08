/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datethreadpoolserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



/**
 *
 * @author rezan
 */
public class DateThreadPoolServer {

    private final static int PORT_NUMBER = 6013;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try {
            ExecutorService threadExec = Executors.newCachedThreadPool();
            
            ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
            
            System.out.println("Waiting for clients to connect...");
            // now listen for connections
            while (true) {
                Socket client = serverSocket.accept();
                
                System.out.println(
                        "Client Connected from " + client.getLocalAddress()
                );

                DateThreadPoolService dateService = 
                        new DateThreadPoolService(client);
                
                threadExec.execute(dateService);
                
            }
            
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
           
    }
    
}
    
    
