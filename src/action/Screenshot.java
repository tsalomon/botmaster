/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

/**
 *
 * @author Tim
 */
public class Screenshot extends Action{
    
    public Screenshot(server.Node node){
        
        super(node);
        
    }
    
    @java.lang.Override
    public void execute(){
        
        protocol.Message ms = new protocol.Message("<screenshot>","");
        super.getNode().sendRequestToClient(ms);
        java.lang.System.out.println("Sent screenshot request to " + super.getNode().ip);

        protocol.Message response = super.getResponse();
        java.lang.String screenshot = response.getActionData();
        java.lang.System.out.println(screenshot);
        
        this.screenshot = screenshot;
        
        super.setReturnvalue(screenshot);

    }
    
    
    
    
    public java.lang.String screenshot;
    
    
    
    
    
}
