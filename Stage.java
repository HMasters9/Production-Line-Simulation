/*
 * Programmer: Hugh Masters
 * Date of modification: 30/05/2019
 * Purpose: Production Stage for processing items
 */

import java.util.*;

public class Stage<T extends processable> {
    private String Name; //Name of Production stage
    private Stage<T>[] previous = null; //Array of previous stages
    private Stage<T>[] next = null; //Array of following stages
    private InterstageQueue<T> preQ; //Supply Queue
    private InterstageQueue<T> postQ; //Store Queue
    private T item; //Item being processed
    private boolean blocked = false;
    private boolean starved = true;
    private TimeGenerator gen;

    //Constructor
    //preconditions: A production stage is being created
    //postconditions: Production stage has been created and initial values set
    public Stage(String name, InterstageQueue preq, InterstageQueue postq,TimeGenerator T) {
        preQ = preq;
        postQ = postq;
        Name = name;
        gen = T;
    }

    //preconditions: Production stage has been created
    //postconditions: Starved has been returned
    public boolean isStarved() {
        return starved;
    }

    //preconditions: Production stage has been created
    //postconditions: Blocked has been returned
    public boolean isBlocked() {
        return blocked;
    }

    //preconditions: Production stage has been created
    //postconditions: Preq and postQ have been set
    public void setStages(Stage<T>[] previousstage, Stage<T>[] nextstage) {
        previous = previousstage;
        next = nextstage;
    }

    //preconditions: Event for begin process has occured
    //postconditions: Production has begun on an item and all subsequent events have been returned
    public Collection<Event> beginprocess(double time) {
        blocked = false;
        item = preQ.remove();
        starved = false;
        PriorityQueue<Event> newevents = new PriorityQueue<>();
        double exittime = time + gen.GenerateTime();
        item.beginProcess(time, Name);
        CompleteEvent newevent = new CompleteEvent(this, exittime);
        newevents.add(newevent);
        if (previous != null) {
            for (int i = 0;i<previous.length;i++){
                if (previous[i].isBlocked()) {
                    PriorityQueue<Event> extraevents = previous[i].endprocess(time);
                    if (extraevents != null)
                        newevents.addAll(extraevents);
                    break;
                }
            }
        }
        return newevents;
    }

    //preconditions: Event for finish process has occured
    //postconditions: Production has completed an the item has moved to the next storage
    public PriorityQueue<Event> endprocess(double time) {
        item.complete(time);
        if (postQ.isFull()) {
            blocked = true;
            return null;
        } else {
            PriorityQueue<Event> newevents = new PriorityQueue<>();
            item.exit(time);
            blocked = false;
            postQ.add(item);
            item = null;
            if (next != null) {
                for (int i = 0;i<next.length;i++){
                    if (next[i].isStarved()) {
                      newevents.add(new BeginEvent(next[i],time));
                      break;
                    }
                }
            }
            if (preQ.isEmpty()) {
                starved = true;
                if (newevents.size()>0)
                    return newevents;
                else return null;
            }
            else {
                newevents.add(new BeginEvent(this,time));
                return newevents;
            }
        }
    }
}


