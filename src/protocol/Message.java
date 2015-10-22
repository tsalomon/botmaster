/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package protocol;

import java.io.PrintWriter;

/**
 *
 * @author Tim
 */
public class Message {
    
    public Message(String data){}
    
    // specify a new Mesasage with an action
    public Message(String action, String actionData){
        
        this.action = action;
        this.actionData = actionData;
        
    }
    
    /// send the message over a netwrok stream
     public void send(PrintWriter connection){
        
        try{
            connection.println(this.toString());
            connection.flush();
            //System.out.println(this.toString());
        }catch(Exception ex){
            System.out.println("Could not send Message.");
        }
        
        
    }
    
    @java.lang.Override
    
    // method used in parsing requests and responses
    public String toString(){
        
        return  
               action_marker + action + action_marker +
               actionData_marker + actionData + actionData_marker +
               eof_marker;
        
    }
    
    // creates new Message from netwrok data
    public static Message parseDataToMessage(String data){

        
        Message ms = null;
        if(data.isEmpty() == false){
        int begin_action_marker = data.indexOf("<action>")+8;
        int end_action_marker = data.lastIndexOf("<action>");

        String action = data.substring(begin_action_marker, end_action_marker);

        int begin_actionData_marker = data.indexOf("<actionData>")+0xc;
        int end_actionData_marker = data.lastIndexOf("<actionData>");

        String actionData = data.substring(begin_actionData_marker, end_actionData_marker);
        

        ms = new Message(action, actionData);

        
            
        }
            
        return ms;

    }

    // specify action in request
    public void setAction(String action){
        this.action = action;

    }
    
    //get action data
    public String getActionData(){
        return actionData;

    }
    // get action
    public String getAction(){
        return action;

    }

    // set action data
    public void setActionData(String action){
        this.actionData = action;

    }

    public String eof_marker = "\r\n";
    
    public String action;
    public String action_marker = "<action>";
    
    public String actionData;   
    public String actionData_marker = "<actionData>";
    
    
    
}
