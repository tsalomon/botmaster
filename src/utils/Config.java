/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jwsadmin
 */
public class Config {

    // process the configuration file
    static public String[] readConfig(String filepath) {
        String[] config= new String[8];
        
        try{
        BufferedReader reader = new BufferedReader(new FileReader(filepath));

        
        int index = 0;

        while ((config[index] =reader.readLine()) != null) {
            
            index++;
            
        }
        reader.close();

        }catch(IOException e){
            System.out.println("Could not locate configuration file.");

        }

        
        String[] data = new String[2];

        // gather required info from conf file
        for(String line: config){
            

            if(line != null){
            if(line.startsWith("address=") ){
                data[0] = line.substring((line.indexOf("address=")+8), line.length());
                
            }else if(line.startsWith("port=")){
                data[1] = line.substring((line.indexOf("port=")+5), line.length());
                
            }
            }
        }
        
        return data;

    }
    
}
