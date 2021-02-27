/*
 * Programmer: Hugh Masters
 * Date of modification: 30/05/2019
 * Purpose: Class for storing Stage statistics
 */
public class Stageinfo {
    private String stagename;
    private double Timeblocked = 0;
    private double Timebusy = 0;

    //Constructor
    //preconditions: A stageinfo is being created
    //postconditions: A stageinfo has been created and name set
    public Stageinfo(String name){
        stagename = name;
    }

    //preconditions: Timeblocked is being requested
    //postconditions: Timeblocked has been returned
    public double getTimeblocked() {
        return Timeblocked;
    }

    //preconditions: Timeblocked is being increased
    //postconditions: Timeblocked has been increased
    public void increaseTimeblocked(double timeblocked) {
        Timeblocked += timeblocked;
    }

    //preconditions: Timebusy is being requested
    //postconditions: Timebusy has been returned
    public double getTimebusy() {
        return Timebusy;
    }

    //preconditions: Timebusy is being increased
    //postconditions: Timebusy has been increased
    public void increaseTimebusy(double timebusy) {
        Timebusy += timebusy;
    }

    //preconditions: Stagename is being requested
    //postconditions: Stagename has been returned
    public String getStagename(){
        return stagename;
    }

    //preconditions: Stageinfo is being printed
    //postconditions: Stageinfo has been printed, including percentage, starvtime and work
    public String toString(){
        double percentage = getTimebusy()/10000000 * 100;
        double starve = 10000000 - getTimebusy() - getTimeblocked();
        if (stagename.length() == 2)
            return getStagename() + "          " + String.format("%4.2f",percentage) + "%   " + String.format("%10.2f",starve) + "   " + String.format("%10.2f",getTimeblocked()) + "\n";
        else
            return getStagename() + "         " + String.format("%4.2f",percentage) + "%   " + String.format("%10.2f",starve) + "   " + String.format("%10.2f",getTimeblocked()) + "\n";
    }
}
