/*
 * Programmer: Hugh Masters
 * Date of modification: 30/05/2019
 * Purpose: Production queue for start of production line
 */
public class InfiniteQueue extends InterstageQueue<Item> {
    //default constructor
    public InfiniteQueue(){}

    private boolean isempty = false; //Indicates if queue is empty

    //preconditions: An infinitequeue has been created
    //postconditions: queue status has been returned
    public boolean isEmpty(){
        return isempty;
    }

    //preconditions: An item is being removed from the queue
    //postconditions: An item has been created and returned
    public Item remove(){
        Item newitem = new Item();
        return newitem;
    }

    //preconditions: Infinitequeue has been completed
    //postconditions: Queue will return empty on future isEmpty calls
    public void end(){
        isempty = true;
    }
}
