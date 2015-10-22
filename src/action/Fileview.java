/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import java.io.File;
import javax.swing.tree.TreeModel;
import server.Node;



/**
 *
 * @author Tim
 */
public class Fileview extends Action{
    
    public Fileview(Node node){
        super(node);
    }
    
    public void getFileTree(){
        File[] root = File.listRoots();
        File rootDir = root[0];
        File winRoot = new File("C:/");
        //this.filetree = new TreeModel(winRoot);
        
    }
    public void execute(){
        
    }
    
    
    
    public TreeModel filetree;
    
}
