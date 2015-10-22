/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package action;

/**
 *
 * @author 1salomonstim
 */
public class SystemInfo extends Action{
    
    
    public SystemInfo(server.Node node){
        
        super(node);
        
    }
    
    public void execute(){
        
        protocol.Message ms = new protocol.Message("<system>","");
        super.getNode().sendRequestToClient(ms);
        java.lang.System.out.println("Sent sysinfo request to " + super.getNode().ip);

        protocol.Message response = super.getResponse();
        java.lang.String sys = response.getActionData();
        java.lang.System.out.println(sysinfo);
        
        
        this.sysinfo = sys;
        
        super.setReturnvalue(this.sysinfo);

    }
    
    
    
    
    public String sysinfo;
}
