/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfStart;

/**
 *
 * @author omrsemr
 */
public class Test {
    /** Main method
     * @param args **/
    public static void main(String args[]){
        Max max = new Max();
        int i = 5;
        int j = 7;
        int k = Max.max(i, j); // Class_name.Method_name(parameter values)  
        System.out.println("The maximum between " + i + " and " + j + " is " + k );
        
        NPrintln.nPrintln("James", 7);
    }
    
}
