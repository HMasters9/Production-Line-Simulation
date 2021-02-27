/*
 * Programmer: Hugh Masters
 * Date of modification: 30/05/2019
 * Purpose: Abstract class for events
 */
import java.util.Collection;

public abstract class Event implements Comparable<Event>{
    private double time; //Time at which the event will occur

    //Default constructor
    public Event(){}

    //Constructor
    //preconditions: A new event is being created
    //postconditions: A new event has been created and initial values set
    public Event(double settime){
        time=settime;
    }

    //preconditions: 2 events are being compared
    //postconditions: Order indicating integer has been returned
    public int compareTo(Event e){
        if (time > e.getTime())
            return 1;
        else return -1;
    }

    //preconditions: Time is being requested
    //postoncitions: Time has been returned
    public double getTime() {
        return time;
    }

    //preconditions: Time is being set
    //postconditions: Time has been set
    public void setTime(double time) {
        this.time = time;
    }

    //preconditions: Event is the next event to occur
    //postconditions: Collection of all subsequent events has been returned
    public abstract Collection<Event> getSubsequentEvents();

    //preconditions: An event is being forced to occur early
    //postconditions: Collection of all subsequent events and been returned
    public abstract Collection<Event> getSubsequentEvents(double setTime);
}
