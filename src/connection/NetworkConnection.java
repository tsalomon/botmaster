/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Tim
 */
public class NetworkConnection extends Socket{
    
    public NetworkConnection(String ip, int port){
        this.ip = ip; this.port = port;
    }
    
    
    // starts socket connection
    public void connect() throws IOException{
        
        try{
            connection = new Socket(getIP(),getPort());
        }catch(UnknownHostException ex){
            System.out.println("Could not find host at " + this.getIP());           
            
        }
        
    
        
    }
    
    // disconnects socket connection
    public void disconnect(){
        while(connection.isClosed() == false){
            
            try{
                connection.close();
                
            }catch(IOException ex){
                
            }
                
            
        }
        
    
    }
    
    public String getIP(){
        return this.ip;
    }
    
    //gets network stream
    public PrintWriter getPrintWriter() throws java.io.IOException{
        
        PrintWriter dos = new java.io.PrintWriter(connection.getOutputStream(), false);
        return dos;
    
    }
    //gets network stream
    public BufferedReader getBufferedReader() throws java.io.IOException{
        
        BufferedReader dis = new java.io.BufferedReader(new java.io.InputStreamReader(connection.getInputStream()));
        return dis;
    
    }
    
    public int getPort(){
        return this.port;
    }
    
    public Socket connection;
    public String ip;
    public int port;
}
