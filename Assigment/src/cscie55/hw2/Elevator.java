package cscie55.hw2;

enum Direction {MOVE_UP, MOVE_DOWN};

public class Elevator
{
    public static final int CAPACITY     = 10;
    
    public Elevator(Building building)
    {
        this.building               = building;
        current_direction           = Direction.MOVE_UP;
        current_floor               = 0;
        destined_passengers         = new int[Building.FLOORS];
        destined_passengers[0]      = 0;
        destined_stops              = new int[Building.FLOORS];
        destined_stops[0]           = 0;
        all_passengers_from_floor   = 0;
    }

   
    public int currentFloor()
    {
        return current_floor + (Building.FLOORS - TOP_FLOOR);
    }

    
    public int passengers()
    {
        return all_passengers_onboard();
    }

    
    public void move()
    {
        destined_passengers[current_floor] = 0;

        destined_stops[current_floor] = 0;
        
        if(current_floor == GROUND_FLOOR)
        {
            current_direction           = Direction.MOVE_UP;
        }
        if(current_floor == TOP_FLOOR)
        {
            current_direction = Direction.MOVE_DOWN;
        }
        
        if(current_direction == Direction.MOVE_UP)
        {
            current_floor++;
        }
        if(current_direction == Direction.MOVE_DOWN)
        {
            current_floor--;
        }
        
        destined_passengers[current_floor] = 0;

        int capacity_now = CAPACITY - passengers();
        int floor_boarding_count = building.floor(current_floor+1).passengersWaiting();
      
        if((capacity_now  > 0 ))
        {
            // Probably need to go away counting for all passengers by destination
            if(floor_boarding_count > 0)
            {
                int can_board_count = (capacity_now >= floor_boarding_count)?floor_boarding_count:capacity_now;
                //destined_passengers[current_floor] += now_boarding;
                all_passengers_from_floor += can_board_count;
                building.floor(current_floor+1).passengersBoarded(can_board_count, this);
            }
        }
        // On reaching Ground floor it resets
        if((current_direction == Direction.MOVE_DOWN) && (current_floor == GROUND_FLOOR))
        {
            all_passengers_from_floor   = 0;
            for (int i = 0; i <= TOP_FLOOR; i++)
            {
                destined_passengers[i]  = 0;
                destined_stops[i]       = 0;
            }
        }
    }

    /**
    * This method boards a passenger to a destination floor.
    * @param destinationFloorNumber Starts from 1 - FLOORS and NOT from 0 to FLOORS
    * @return int This returns 0 on successful boarding else non positive number
    * @throws ElevatorFullException This is full elevator condition
    * @see ElevatorFullException
    */
    public int boardPassenger(int destinationFloorNumber) throws ElevatorFullException
    {
        //Flag to stop at destinationFloorNumber
        destined_stops[destinationFloorNumber-1]++;

        if(passengers() >= CAPACITY)
        {
            throw new ElevatorFullException();
        }
        int ret = 0;
        // We will have to figure out if a passenger wants to board same floor
        if(destinationFloorNumber >= GROUND_FLOOR && destinationFloorNumber <= TOP_FLOOR)
        {
            destined_passengers[destinationFloorNumber-1]++;
        }else
        {
            ret = -1;
        }
        return ret;
    }

    /**
    * This method prints state of the object at any instant of time
    * @return String This returns Elevator State and total number of passeengers
    */
    public String toString() {

        int all_passengers = all_passengers_onboard();
        return "Elevator " + (current_floor+1) + ": " + all_passengers + " passengers";
    }

    /**
    * This method computes all passeengers on board the elevator
    * @return int This returns total number of passeengers
    */
    private int all_passengers_onboard()
    {
        int all_passengers = all_passengers_from_floor;
        for (int i = 0; i <= TOP_FLOOR; i++)
        {
            all_passengers += destined_passengers[i];
        }
        return all_passengers;
    }

    // Private members for internal use only

    // Define Top and Ground floor values
    private static final int    TOP_FLOOR           = Building.FLOORS -1;
    private static final int    GROUND_FLOOR        = 0;

    // current_floor ranges from [GROUND_FLOOR - TOP_FLOOR] and starts from GROUND_FLOOR
    private int                 current_floor       = GROUND_FLOOR;

    // Direction of Elevator movement
    private Direction           current_direction   = Direction.MOVE_UP;

    // Array for passengers count for each floor
    private int                 destined_passengers[];
    // Array for stop needed for each floor
    private int                     destined_stops[];
    private Building            building;
    private int                 all_passengers_from_floor;
}