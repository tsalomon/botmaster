/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author Tim
 */
public class Node {
 

    public Node(java.net.Socket s) throws java.io.IOException {
    
        //gets network streams
        this.dis = new java.io.BufferedReader(new java.io.InputStreamReader(s.getInputStream()));
        this.dos = new java.io.PrintWriter(s.getOutputStream(), false);
        
        //gets ip address of connectiong client
        this.ip = s.getInetAddress();
        
        //geolocation happen here
        com.maxmind.geoip.LookupService lookup = new com.maxmind.geoip.LookupService(System.getProperty("user.dir") + "/GeoIP.dat");
        System.out.println(System.getProperty("user.dir") + System.getProperty("file.separator") +"GeoIP.dat");
        this.geolocation = lookup.getCountry(ip).getName();
    
    }
    
    // method to send a request to the client paired with this node
    public void sendRequestToClient(protocol.Message message){
      
        if(message.toString() !=null){
        message.send(dos);
        
        
        }
      
    }
    
    // returns the location of the remote client
    public String getLocation(){
        return this.geolocation;
    }
   
    public java.io.BufferedReader dis;
    public java.io.PrintWriter dos;
    public java.net.InetAddress ip;
    private String geolocation;
    public String[] sysinfo = new String[4];
    public boolean sysenum = false;

}
