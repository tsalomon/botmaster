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

// main class which defines format for all actions allowed on connected clients
public class Action {
    
    public Action(Node node){
        this.nd = node;
    }
    
    // execute the command
    public void execute(){}
    
    // recieve command response
    public protocol.Message getResponse(){

        java.lang.String re= "";
        protocol.Message response = null;
        try {
            while(!(re = nd.dis.readLine()).isEmpty()){
             
            response =protocol.Message.parseDataToMessage(re);

            }
            
        } catch (java.io.IOException ex) {
            java.lang.System.out.println("Could not read response.");
        }

        return  response;
        
    }
    
    public Node getNode(){
        return this.nd;
    }
    
    // get returned data
    public Object getReturnvalue() {
        return returnvalue;
    }

    public void setReturnvalue(Object returnvalue) {
        this.returnvalue = returnvalue;
    }
    

    private Node nd;
    private Object returnvalue;

}
