/*
 * Programmer: Hugh Masters
 * Date of modification: 30/05/2019
 * Purpose: interface for items that can be processed
 */
public interface processable {

    //preconditions: The item has entered a production stage
    //postconditions: Time of entry has been recorded
    public void beginProcess(double time, String stage);

    //preconditions: An item is leaving a production stage
    //postconditions: Time of exit has been recorded
    public void exit(double time);

    //preconditions: An item has completed production
    //postconditions: time of completion has been recorded
    public void complete(double time);
}
