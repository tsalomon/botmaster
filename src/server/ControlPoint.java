/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import javax.swing.JFrame;
import utils.Config;

/**
 *
 * @author Tim
 */
public class ControlPoint {

    
    // start the server and begin accepting connections
    public void startServer() throws java.io.IOException {
      
    // read port info from config file
    String[] info = Config.readConfig(System.getProperty("user.dir") + "/control-config.txt");
    port = Integer.parseInt(info[1]);
    
    java.net.ServerSocket ss = new java.net.ServerSocket(port);
    java.lang.System.out.println("Server started on port: " + port);
    
    
    //want to change from polling to event based functionality to add clients to server pool

    while (true) {
      
      // process new connections  
      java.net.Socket s = ss.accept();
      Node st = new Node(s);
      // add to list of clients
      clients.add((Node)st);
      numclients++;
      java.lang.System.out.println("New client connected with ip: "+ss.getLocalSocketAddress() +". Total clients: " + (numclients));
    
      
    }
  }
    
   public int getPort(){
       return port; 
   }
 
  public java.util.ArrayList<Node> clients = new java.util.ArrayList();
  public int numclients = 0;
  
  private int port;
  
    
    
    
}
