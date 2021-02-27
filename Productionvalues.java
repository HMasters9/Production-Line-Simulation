/*
 * Programmer: Hugh Masters
 * Date of modification: 30/05/2019
 * Purpose: Object to store information in an item
 */
public class Productionvalues {
    private String Name=""; //Name of stage
    private double timeIn; //Time of entry
    private double timeOut; //Time or exit
    private double timeDone; //Time for completion

    //preconditions: Timein is being requested
    //postoncitions: Timein has been returned
    public double getTimeIn() {
        return timeIn;
    }

    //preconditions: Timein is being set
    //postoncitions: Timein has been set
    public void setTimeIn(double timeIn) {
        this.timeIn = timeIn;
    }

    //preconditions: Name is being requested
    //postconditions: Name has been returned
    public String getName() {
        return Name;
    }

    //preconditions: Name is being set
    //postoncitions: Name has been set
    public void setName(String name) {
        Name = name;
    }

    //preconditions: Timeout is being set
    //postoncitions: Timeout has been set
    public void setTimeOut(double timeOut) {
        this.timeOut = timeOut;
    }

    //preconditions: Item has exited production stage
    //postconditions: Time item was blocked has been returned
    public double getTimeBlocked() {
        double timeblocked = timeOut - timeIn - timeDone;
        return timeblocked;
    }

    //preconditions: Item has completed production
    //postoncitions: Production time has been returned
    public double getTimeDone() {
        return timeDone;
    }

    //preconditions: Item has completed production
    //postconditions: Productiuon time has been set
    public void setTimeDone(double timeDone) {
        this.timeDone = timeDone;
    }

    //preconditions: Item has exited a production stage
    //postoncitions: time of exit has been returned
    public double getTimeOut() {
        return timeOut;
    }
}
