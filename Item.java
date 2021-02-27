/*
 * Programmer: Hugh Masters
 * Date of modification: 30/05/2019
 * Purpose: Item to be processed and collect statistical data
 */

public class Item implements processable {

    private Productionvalues[] InfoStore = new Productionvalues[6];
    private int stageno = 0;

    //Method to collect statistical information when an item begins production
    //preconditions: Item is being processed by a production stage
    //postcondition: Time of process begin has been recorded
    public Item(){
        for (int i =0;i<6;i++){
            InfoStore[i] = new Productionvalues();
        }
    }

    //preconditions: The item has entered a production stage
    //postconditions: Time of entry has been recorded
    public void beginProcess(double time, String stagename){
        InfoStore[stageno].setTimeIn(time);
        InfoStore[stageno].setName(stagename);
    }

    //preconditions: An item has finished production
    //postconditions: Time of completion has been recorded
    public void complete(double time){
        if (InfoStore[stageno].getTimeDone() == 0)
            InfoStore[stageno].setTimeDone(time - InfoStore[stageno].getTimeIn());
    }

    //preconditions: An item is leaving a production stage
    //postconditions: Time of exit has been recorded
    public void exit(double time){
        InfoStore[stageno].setTimeOut(time);
        stageno++;
        if (stageno == 6) stageno = 0;
    }

    //preconditions: Item has undergone production
    //postconditions: First production stage stats have been returned
    public Productionvalues read(){
        return InfoStore[stageno++];
    }

    //preconditions: Item has completed production
    //postconditions: String of path has been returned
    public String getPath(){
        if (InfoStore[2].getName() == "S2a"){
            if (InfoStore[4].getName() == "S4a"){
                return "AA";
            }
            else return "AB";
        }
        else
        {
            if (InfoStore[4].getName() == "S4a"){
                return "BA";
            }
            else return "BB";
        }
    }
}
