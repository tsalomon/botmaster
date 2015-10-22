/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package client;

import connection.NetworkConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import protocol.Message;
import protocol.MessageParser;

/**
 *
 * @author 1salomonstim
 */


public class Client {

    public Client(NetworkConnection connection){

        this.connectionToServer = connection;
       
    }
    
    //connects client to server
    public void connect(){

        try{
            connectionToServer.connect();
            responseOutStream = connectionToServer.getPrintWriter();
            requestInStream = connectionToServer.getBufferedReader();
        }catch(IOException ex){
            System.out.println("Could not connect to server." + ex.getMessage() + ex.toString());
        }
        
        
        // starts module that process requests
        requestListener.run();
        
        

    }
    
    // request processor
    Runnable requestListener = new Runnable(){
            public void run(){
                beginRequestListener();
            }
        
        };

    public void beginRequestListener(){
   
        String request;
        
        try {
            //always listen for requests 
            
            //change this to event based request handling
            
            
            while(true){
            // when request is found, process
            while(!(request = requestInStream.readLine()).isEmpty()){
                
                System.out.println("Recieved request: " + request + request.length()); 
                
                //create reponse
                Message response = Message.parseDataToMessage(request); 
                
                //send reponse to server
                sendResponseToServer(response);
 
                }
                
            }
        } catch (java.io.IOException ex) {
            System.out.println("Could not read request stream.");
        } catch(NullPointerException e){
            e.printStackTrace();
            e.getClass();
        }

    }
    
    //sends a response to server
    public void sendResponseToServer(Message ms){
        
            protocol.Message response = MessageParser.compileResponse(ms);
            java.lang.System.out.println("Response to send: "+response);
       
            response.send(responseOutStream);
            responseOutStream.flush();

    }
    
    private BufferedReader requestInStream; 
    private PrintWriter responseOutStream; 
    private NetworkConnection connectionToServer;

}
