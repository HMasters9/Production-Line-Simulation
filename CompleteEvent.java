/*
 * Programmer: Hugh Masters
 * Date of modification: 30/05/2019
 * Purpose: Event for the completion of production
 */
import java.util.Collection;

public class CompleteEvent extends Event {
    private Stage stage;

    //Constructor
    //preconditions: A new event is being created
    //postonditions: A new event has been created and initial values set
    public CompleteEvent(Stage setstage, double settime){
        stage=setstage;
        super.setTime(settime);
    }

    //preconditions: Event is the next event to occur
    //postconditions: Collection of all subsequent events has been returned
    public Collection<Event> getSubsequentEvents(){
        return stage.endprocess(getTime());
    }

    //preconditions: An event is being forced to occur early
    //postconditions: Collection of all subsequent events and been returned
    public Collection<Event> getSubsequentEvents(double setTime){
        return stage.endprocess(setTime);
    }
}
