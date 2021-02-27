/*
 * Programmer: Hugh Masters
 * Date of modification: 30/05/2019
 * Purpose: Produces production times
 */

import java.util.Random;

public class RandomTimeGenerator implements TimeGenerator {
    private double mean;
    private double range;
    private Random R=new Random();

    //Constructor
    public RandomTimeGenerator(double mean,double range){
        this.mean=mean;
        this.range=range;
    }

    //preconditions: Item has begun production
    //postconditions: Time until completion has been returned
    public double GenerateTime() {
        double d = R.nextDouble();
        double generatedtime=mean+range*(d-0.5);
        return  generatedtime;
    }
}
