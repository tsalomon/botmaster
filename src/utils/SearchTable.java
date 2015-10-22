/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import javax.swing.JTable;

/**
 *
 * @author jwsadmin
 */
public class SearchTable {

   

   //must sort gui table in ascending order before searching table
   //returns the index of the speciifed search key 
   public int searchTable(JTable table,String key, int column){



       String[] row_data = new String[table.getModel().getRowCount()];



       for(int i=0; i<table.getModel().getRowCount(); i++){


           row_data[i] = String.valueOf(table.getModel().getValueAt(i, column));

       }

       int index = this.searchString(row_data, key);



       return index;

   }

   // uses binary search the find the key in the table
   private int searchString(String[] names, String key) {
    int first = 0;
    int last  = names.length;
  
    while (first < last) {
        int mid = (first + last) / 2;
        if (!names[mid].contains(key)) {
            last = mid;
        } else if (!names[mid].contains(key)) {
            first = mid + 1;
        } else {
            return mid;
        }
    }
    return -(first + 1);
}





   

}
