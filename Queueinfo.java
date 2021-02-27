/*
 * Programmer: Hugh Masters
 * Date of modification: 30/05/2019
 * Purpose: Class for storing Queue statistics
 */
public class Queueinfo {
    private double totaltimein = 0; //Total time all items spent enqueued
    private String Queuename; //Name of queue

    //Constructor
    //preconditions: A Queueinfo is being created
    //postonditions: A Queueinfo has been created and name set
    public Queueinfo(String name){
        Queuename = name;
    }

    //preconditions: Items have been stored in a queue
    //postconditions: Total time all items spent in queue has been returned
    public double getTotaltimein() {
        return totaltimein;
    }

    //preconditions: An item has spent time in a queue
    //postconditions: totaltimein has been increased by input value
    public void increaseTotaltimein(double totaltimein) {
        this.totaltimein += totaltimein;
    }

    //preconditions: Queue is being printed
    //postconditions: String with avgitems and avgtime has been returned
    public String toString(int total){
        return Queuename + "              "+ String.format("%7.2f",getTotaltimein()/total) + "      " + String.format("%7.2f",getTotaltimein()/10000000)+"\n";
    }
}
