/*
 * Programmer: Hugh Masters
 * Date of modification: 30/05/2019
 * Purpose: Main class of production line simulation
 */

import java.util.*;

public class PA3 {
    public static void main(String[] args){

        //Read input values
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);
        int Qmax = Integer.parseInt(args[2]);

        //Creates Time Generators
        RandomTimeGenerator inline = new RandomTimeGenerator(M,N);
        RandomTimeGenerator parallel = new RandomTimeGenerator(M*2,N*2);

        //Create Queue of all events
        PriorityQueue<Event> events = new PriorityQueue<>();

        //Creates statistics class
        Statistics stats = new Statistics();

        //Create Inter-stage storages
        InfiniteQueue qstart = new InfiniteQueue();
        InterstageQueue q01 = new InterstageQueue(Qmax);
        InterstageQueue q12 = new InterstageQueue(Qmax);
        InterstageQueue q23 = new InterstageQueue(Qmax);
        InterstageQueue q34 = new InterstageQueue(Qmax);
        InterstageQueue q45 = new InterstageQueue(Qmax);
        EndQueue qend = new EndQueue();

        //Create production stages
        Stage<Item>[] S0 = new Stage[1];
        Stage<Item>[] S1 = new Stage[1];
        Stage<Item>[] S2 = new Stage[2];
        Stage<Item>[] S3 = new Stage[1];
        Stage<Item>[] S4 = new Stage[2];
        Stage<Item>[] S5 = new Stage[1];

        //Initialises Production Stages with queues and calculation values
        S0[0] = new Stage<>("S0",qstart, q01,inline);
        S1[0] = new Stage<>("S1",q01, q12,inline);
        S2[0] = new Stage<>("S2a",q12, q23,parallel);
        S2[1] = new Stage<>("S2b",q12, q23,parallel);
        S3[0] = new Stage<>("S3",q23, q34,inline);
        S4[0] = new Stage<>("S4a",q34, q45,parallel);
        S4[1] = new Stage<>("S4b",q34, q45,parallel);
        S5[0] = new Stage<>("S5",q45, qend,inline);

        //Set previous and next stages for each production stage
        S0[0].setStages(null, S1);
        S1[0].setStages(S0, S2);
        S2[0].setStages(S1, S3);
        S2[1].setStages(S1, S3);
        S3[0].setStages(S2, S4);
        S4[0].setStages(S3, S5);
        S4[1].setStages(S3, S5);
        S5[0].setStages(S4, null);

        //Create first event and store in PriorityQueue
        events.add(new BeginEvent(S0[0],0));

        //Create the initialevent
        Event initialevent = events.poll();

        //Begin Loop of events
        while (initialevent.getTime() < 10000000){
            Collection<Event> nextevents = initialevent.getSubsequentEvents();
            if (nextevents != null)
                events.addAll(nextevents);
            initialevent = events.poll();
        }

        //Stops infinite start queue
        qstart.end();

        //Continue events at time 10,000,000 to extract all items currently in production line
        while (initialevent !=null){
            Collection<Event> nextevents = initialevent.getSubsequentEvents(10000000);
            if (nextevents !=null)
                events.addAll(nextevents);
            if (events.size()>0)
                initialevent = events.poll();
            else initialevent = null;
        }

        //Add all data to Statistics object
        while (qend.size()>0){
            stats.add(qend.remove());
        }

        //Prints All Statistics
        System.out.print(stats);
    }
}
