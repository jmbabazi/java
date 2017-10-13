package cscie55.hw2;

public class Building
{
  
    public static final int NUMBER_OF_FLOORS = 7;

    public Building()
    {
        elevator = new Elevator(this);
        floors = new Floor[NUMBER_OF_FLOORS];
        for(int i = 0; i < NUMBER_OF_FLOORS; i++)
        {
            floors[i] = new Floor(this, i);
        }
    }

    public Elevator elevator()
    {
        return elevator;
    }

    public Floor floor(int floorNumber)
    {
        if(floorNumber <= NUMBER_OF_FLOORS)
        {
            return floors[floorNumber -1];
        }else
        {
            return null;
        }
    }

    public String toString() {

        return "TOTAL NUMBER_OF_FLOORS " + (NUMBER_OF_FLOORS) ;
    }

    private Elevator elevator;
    private Floor floors[];
}
