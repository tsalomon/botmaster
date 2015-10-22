/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Tim
 */
public class Command extends Action{
    
        public Command(server.Node node, String command){
        
        super(node);
        this.command = command;
        
    }
    
    @java.lang.Override
    public void execute(){
        
        protocol.Message ms = new protocol.Message("<cmd>",command);
        super.getNode().sendRequestToClient(ms);
        java.lang.System.out.println("Sent command request to " + super.getNode().ip);

        protocol.Message response = super.getResponse();
        java.lang.String output = response.getActionData();
        java.lang.System.out.println(output);
        
        
                
        byte[] out = Base64.decode(output);
        try {
            this.output = new String(out, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        
        super.setReturnvalue(this.output);

    }
    
    
    
    
    public java.lang.String output;
    private String command;
    
    
}
