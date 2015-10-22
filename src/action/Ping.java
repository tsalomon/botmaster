/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package action;

import server.Node;

/**
 *
 * @author Timothy
 */
public class Ping extends Action{
    
    public Ping(Node node){
        super(node);
    }
    
    @Override
    public void execute(){
        
        protocol.Message ms = new protocol.Message("<ping>","");
        super.getNode().sendRequestToClient(ms);
        java.lang.System.out.println("Sent ping request to " + super.getNode().ip);

        protocol.Message response = super.getResponse();
        java.lang.String pingms = response.getActionData();
        java.lang.System.out.println(pingms);
        
        this.pms = pingms;
        
        super.setReturnvalue(pms);

    }
    
    
    
    
    public String pms;
    
   
    
    
}
