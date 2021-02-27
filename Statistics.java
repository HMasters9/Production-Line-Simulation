/*
 * Programmer: Hugh Masters
 * Date of modification: 30/05/2019
 * Purpose: Class for calculating and printing statistics
 */
public class Statistics {
    //Production Stage Statistics
    private Stageinfo S0 = new Stageinfo("S0");
    private Stageinfo S1 = new Stageinfo("S1");
    private Stageinfo S2a = new Stageinfo("S2a");
    private Stageinfo S2b = new Stageinfo("S2b");
    private Stageinfo S3 = new Stageinfo("S3");
    private Stageinfo S4a = new Stageinfo("S4a");
    private Stageinfo S4b = new Stageinfo("S4b");
    private Stageinfo S5 = new Stageinfo("S5");

    //StorageQueue Statistics
    private Queueinfo q01 = new Queueinfo("Q1");
    private Queueinfo q12 = new Queueinfo("Q2");
    private Queueinfo q23 = new Queueinfo("Q3");
    private Queueinfo q34 = new Queueinfo("Q4");
    private Queueinfo q45 = new Queueinfo("Q5");

    //Path Statistics
    private int AA=0;
    private int AB=0;
    private int BA=0;
    private int BB=0;

    //Default constructor
    public Statistics(){}

    //preconditions: An item is being added to the statistics of the system
    //postconditions: All information from item has been collected and included in statistics
    public void add(Item I){
        for(int i = 0;i<6;i++){
            Productionvalues newvalues = I.read();
            String stage = newvalues.getName();
            switch (stage) {
                case "S0":
                    S0.increaseTimeblocked(newvalues.getTimeBlocked());
                    S0.increaseTimebusy(newvalues.getTimeDone());
                    q01.increaseTotaltimein(-newvalues.getTimeOut());
                    break;
                case "S1":
                    S1.increaseTimeblocked(newvalues.getTimeBlocked());
                    S1.increaseTimebusy(newvalues.getTimeDone());
                    q01.increaseTotaltimein(newvalues.getTimeIn());
                    q12.increaseTotaltimein(-newvalues.getTimeOut());
                    break;
                case "S2a":
                    S2a.increaseTimeblocked(newvalues.getTimeBlocked());
                    S2a.increaseTimebusy(newvalues.getTimeDone());
                    q12.increaseTotaltimein(newvalues.getTimeIn());
                    q23.increaseTotaltimein(-newvalues.getTimeOut());
                    break;
                case "S2b":
                    S2b.increaseTimeblocked(newvalues.getTimeBlocked());
                    S2b.increaseTimebusy(newvalues.getTimeDone());
                    q12.increaseTotaltimein(newvalues.getTimeIn());
                    q23.increaseTotaltimein(-newvalues.getTimeOut());
                    break;
                case "S3":
                    S3.increaseTimeblocked(newvalues.getTimeBlocked());
                    S3.increaseTimebusy(newvalues.getTimeDone());
                    q23.increaseTotaltimein(newvalues.getTimeIn());
                    q34.increaseTotaltimein(-newvalues.getTimeOut());
                    break;
                case "S4a":
                    S4a.increaseTimeblocked(newvalues.getTimeBlocked());
                    S4a.increaseTimebusy(newvalues.getTimeDone());
                    q34.increaseTotaltimein(newvalues.getTimeIn());
                    q45.increaseTotaltimein(-newvalues.getTimeOut());
                    break;
                case "S4b":
                    S4b.increaseTimeblocked(newvalues.getTimeBlocked());
                    S4b.increaseTimebusy(newvalues.getTimeDone());
                    q34.increaseTotaltimein(newvalues.getTimeIn());
                    q45.increaseTotaltimein(-newvalues.getTimeOut());
                    break;
                case "S5":
                    S5.increaseTimeblocked(newvalues.getTimeBlocked());
                    S5.increaseTimebusy(newvalues.getTimeDone());
                    q45.increaseTotaltimein(newvalues.getTimeIn());
                    break;
            }
        }
        switch (I.getPath()){
            case "AA":
                AA++;
                break;
            case "AB":
                AB++;
                break;
            case "BA":
                BA++;
                break;
            case "BB":
                BB++;
                break;
        }
    }

    //preconditions: Statistics are being printed
    //postconditions: A string of all statistics has been returned
    public String toString(){
        String finalString = "Production Stations: \n--------------------------------------------\n";
        finalString += "Stage:     Work[%]    Starve[t]     Block[t]\n";
        finalString += S0.toString();
        finalString += S1.toString();
        finalString += S2a.toString();
        finalString += S2b.toString();
        finalString += S3.toString();
        finalString += S4a.toString();
        finalString += S4b.toString();
        finalString += S5.toString();

        int total = AA+AB+BA+BB;
        finalString += "\nStorage Queues: \n------------------------------------\n";
        finalString += "Store        AvgTime[t]     AvgItems\n";
        finalString += q01.toString(total);
        finalString += q12.toString(total);
        finalString += q23.toString(total);
        finalString += q34.toString(total);
        finalString += q45.toString(total);

        finalString += "\nProduction Paths: \n--------------------\n";
        finalString += "S2a -> S4a:     " + AA+"\n";
        finalString += "S2a -> S4b:     " + AB+"\n";
        finalString += "S2b -> S4a:     " + BA+"\n";
        finalString += "S2b -> S4b:     " + BB+"\n";

        return finalString;
    }
}

