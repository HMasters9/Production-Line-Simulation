/*
 * Programmer: Hugh Masters
 * Date of modification: 30/05/2019
 * Purpose: Event of beginning production
 */
import java.util.Collection;

public class BeginEvent extends Event {
    private Stage stage;

    //Constructor
    //preconditions: A new event is being created
    //postonditions: A new event has been created and initial values set
    public BeginEvent(Stage setstage, double settime){
        stage=setstage;
        super.setTime(settime);
    }

        //preconditions: Event is the next event to occur
        //postconditions: Collection of all subsequent events has been returned
        public Collection<Event> getSubsequentEvents(){
        return stage.beginprocess(getTime());
    }

        //preconditions: An event is being forced to occur early
        //postconditions: Collection of all subsequent events and been returned
        public Collection<Event> getSubsequentEvents(double setTime){
        return stage.beginprocess(setTime);
    }
}