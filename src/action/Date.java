/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import server.Node;

/**
 *
 * @author Tim
 */
public class Date extends Action{
    
    public Date(Node node){
        
        super(node);
        
    }
    
    @Override
    public void execute(){
        
        protocol.Message ms = new protocol.Message("<date>","");
        super.getNode().sendRequestToClient(ms);
        java.lang.System.out.println("Sent date request to " + super.getNode().ip);

        protocol.Message response = super.getResponse();
        java.lang.String sysdate = response.getActionData();
        java.lang.System.out.println(sysdate);
        
        this.date = sysdate;
        
        super.setReturnvalue(date);

    }
    
    
    
    
    public String date;
    
   
}
