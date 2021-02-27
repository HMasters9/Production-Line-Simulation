/*
 * Programmer: Hugh Masters
 * Date of modification: 18/05/2019
 * Purpose: Inter-Stage storage queue for a production line
 */

import java.util.LinkedList;

public class InterstageQueue<T> extends LinkedList<T> {
    private int Qmax = 0;

    //Default Constructor
    public InterstageQueue(){}

    //preconditions: an InterQueue is being created
    //postconditions: an InterQueue has been created and maximum size set
    public InterstageQueue(int max) {
        super();
        Qmax = max;
    }

    //preconditions: an Element is being added to the queue, queue is not full
    //postconditions: an Element has been added to the end of the queue
    public boolean add(T e){
        if (size() < Qmax){
            addLast(e);
            return true;
        }
        else return false;
    }

    //preconditions: an element is being removed from the queue, Queue is not empty
    //postcondtions: Element has been removed from front of the queue and returned
    public T remove(){
        return poll();
    }

    //preconditions: Size of queue is being queried
    //postconditions: Size of queue has been returned
    public int size(){
        return super.size();
    }

    //preconditions: Status of queue is being queried
    //postconditions: Status of queue has been returned
    public boolean isFull(){
        if (size() < Qmax) return false;
        else return true;
    }

    //preconditions: Status of queue is being queried
    //postconditions: Status of queue has been returned
    public boolean isEmpty(){
        if (size() == 0) return true;
        else return false;
    }

    //preconditions: Queue is being extended
    //postconditions: Qmax has been increased
    public void extend(int A){
        Qmax = Qmax+A;
    }
}