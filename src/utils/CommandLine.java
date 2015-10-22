/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author jwsadmin
 */
public class CommandLine {

    // execute a command through cmd and returns the output
    static public String executeCommand(String cmdline){

        String output = "";
        
        final String dosCommand = cmdline;
      
      try {
         final Process process = Runtime.getRuntime().exec(
            dosCommand);
         final InputStream in = process.getInputStream();
         int ch;
         while((ch = in.read()) != -1) {
            output = output +((char)ch);
         }
      } catch (IOException e) {
         e.printStackTrace();
      }

      
      
        return output;
    }

}
