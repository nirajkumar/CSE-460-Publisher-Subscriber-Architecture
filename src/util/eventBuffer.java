package util;
import java.util.*;
import dataObjects.eventItem;

/* Author: Kenneth Smith 4/19/2013
 * Java class to represent the event queue and act as the "message broker"
 * for the publisher/subscriber architecture for a library system.
 */

public class eventBuffer
{
    private List<eventItem> buffer;     //Arraylist to represent event queue
    
    public eventBuffer()
    {
        buffer = new ArrayList<eventItem>();
        buffer.clear();
    }
    
    //Add a new event to the queue
    public void addEvent(eventItem newEvent)
    {
        buffer.add(newEvent);
    }
    
    //Return event at a given position
    public eventItem getItem(int position)
    {
        return buffer.get(position);
    }
    
    //Look for a publisher type event, when found, look for prior subscribers to that event
    public void dispatchEvents()
    {
        for(int i = 0; i < buffer.size(); i++)  //Iterate through arraylist to find publisher event
        {
            if(buffer.get(i).getEventType().equals("publisher"))
            {
                for(int j = 0; j < i; j++)      //Iterate through arraylist from beginning to current publisher event
                {
                    if(buffer.get(j).getBookType().equals(buffer.get(i).getBookType()))  //if subscriber book type = publisher book type
                        buffer.get(i).bufferMessage(buffer.get(j));                      // notify subscriber
                }
            }
        }
    }
}
