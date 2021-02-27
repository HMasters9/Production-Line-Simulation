/*
 * Programmer: Hugh Masters
 * Date of modification: 30/05/2019
 * Purpose: Queue at end of production line
 */
public class EndQueue extends InterstageQueue<Item> {

    //Constructor
    //preconditions: A EndQueue is being created
    //postcondition: An endqueue has been created and returned
    public EndQueue(){}

    //preconditions: A production stage queries if the endqueue is full
    //postconditions: Returns false
    public boolean isFull(){
        return false;
    }

    //preconditions: An item is being added to the endqueue
    //postconditions: An item has been added to the endqueue
    public boolean add(Item I){
        if (super.isFull()){
            super.extend(5);
        }
        super.add(I);
        return true;
    }
}