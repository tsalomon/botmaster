/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.util.Random;

/**
 *
 * @author jwsadmin
 */
public class PwGen {

    /**
     * @param args the command line arguments
     */
    // generates a random password of a specified length
    public static String generateSecurePass(int length) {

        Random rand = new Random(System.currentTimeMillis());
        char[] chars  = new char[length];

        for(int index = 0; index <chars.length; index++){

            chars[index] = (char)(rand.nextInt(122 -33 + 1) + 33);

        }
        
       return String.valueOf(chars);

    }

}
