/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author omrsemr
 */
public class Box {
     private Object object = null;               
    public void put(Object object) {            
	this.object = object;                      
    }                                            


    public Object get() {                         
	return object;                            
    }                                       

    public static void main(String argv[]) {
	Box box = new Box();
	box.put(10);
	Integer integer = (Integer) box.get();
	System.out.println(integer);
	box.put("10");
	integer = (Integer) box.get();
	System.out.println(integer);
    }
}
    

