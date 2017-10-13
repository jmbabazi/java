/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cscie55.hw1.elevator;

/**
 *
 * @author jmbabazi
 */
public class ElevatorTest {
    
    
    public static void main (String args[]){
    
      Elevator elevator = new Elevator ();  
      
      elevator.move();
      elevator.boardPassenger(3);
      elevator.toString();
      System.out.println(elevator);
          
       }
       
    }
