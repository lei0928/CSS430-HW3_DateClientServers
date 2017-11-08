/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dateclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author rezan
 */
public class DateClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try {
            //make connection to server socket
            Socket socket = new Socket("127.0.0.1",6013);
            InputStream in = socket.getInputStream();
            BufferedReader bin = new
            BufferedReader(new InputStreamReader(in));
            
            // read the date from the socket
            String line;
            while ( (line = bin.readLine()) != null) {
                System.out.println(line);
            }
            
            // close the socket connection
            socket.close();
        }
        catch (IOException ioe) {
                System.err.println(ioe);
        }
    }
    
}
