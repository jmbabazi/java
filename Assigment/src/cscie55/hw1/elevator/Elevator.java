/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cscie55.hw1.elevator;

/**
 *
 * @author omrsemr
 */


public class Elevator {
    
    // no argument constructor
    public Elevator() {
        
        
    }
    //Constant
    public static final int NUMBER_OF_FLOORS = 7;
    
// other fields
    int[] numberOfPassengers = new int[3];
    int newCurrentFloor;
    int currentFloor;
    int directionOfTravel;
    int Passengers;
    int Passenger;
    String floor = "Floor";
    String name1 = "passenger";
    String name2 = "passengers";
    
   public int move() {
           currentFloor = 0;
                   while (currentFloor <= NUMBER_OF_FLOORS) {
                       directionOfTravel = currentFloor + 1;
              if (currentFloor == 1 || currentFloor == 2) {
                  Passengers = numberOfPassengers[2];    
              }
              else if (currentFloor == 3 || currentFloor == 4) {
                  Passengers = numberOfPassengers[1];
              }
              else 
                {
                Passenger = numberOfPassengers[0];
                }
              return currentFloor;
          } 
          
        if (currentFloor == NUMBER_OF_FLOORS){
        directionOfTravel = currentFloor - 1;
        return currentFloor;
        }
          
    return newCurrentFloor;
   }
    
    /**
     *
     * @param destinationFloor
     * @return 
     * 
     */
    public int boardPassenger(int destinationFloor) {
        destinationFloor = newCurrentFloor;
             
                
        switch (destinationFloor) {
            case 1:
            case 2:
                ;
                break;
            case 3:
            case 4:
                Passengers = numberOfPassengers[1];
                break;
            default:
                Passengers = numberOfPassengers[0];
                break;
        }
        return Passengers;
    }
    
    @Override
    public String toString() {
       
        return floor + " "+ newCurrentFloor + ": " + Passengers + " " + name2;
        
    }
   
}
