package util;
import java.util.*;
import java.io.IOException;
import dataObjects.eventItem;

/* Author: Kenneth Smith 4/19/2013
 * Java class to represent the event queue and act as the "message broker"
 * for the publisher/subscriber architecture for a library system.
 */

public class eventBuffer
{
    private List<eventItem> eventPool;  //Arraylist to represent the subscriber events in the event pool
 
    //eventBuffer constructor
    public eventBuffer()
    {
        eventPool = new ArrayList<eventItem>();     //Initial arrayList
        eventPool.clear();                          //Error prevention, not really necessary.
    }
    
    //Add a new event to the queue
    public void addEvent(eventItem newEvent)
    {
        eventPool.add(newEvent);
    }
    
    //Look for a subscriber event that is subscribed to the publisher event. If found, notify subscriber.
    public void dispatchEvent(eventItem publisherEvent)
    {
        subscriber theSubscriber;                                                       //Temp subscriber variable to call non-interfaced subscriber methods
        
        for(int i = 0; i < eventPool.size(); i++)                                       //Cycle through eventPool (subscribers)
            if(publisherEvent.getBookType().equals(eventPool.get(i).getBookType()))     //Check if publisher event book type = current subscriber book type  
            {
                theSubscriber = (subscriber)eventPool.get(i);                           //Set temp subscriber to type cast of eventItem 
                theSubscriber.bufferMessage(publisherEvent.getSenderName());            //Notify subscriber 
            }
    }
}
    
