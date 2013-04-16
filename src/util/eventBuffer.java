package util;
import java.util.*;
import dataObjects.eventItem;

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
    
    //Look for a publisher type event, when found, look for prior subscribers to that event
    public void dispatchEvents()
    {
        for(int i = 0; i < buffer.size(); i++)
        {
            if(buffer.get(i).getEventType().equals("Publish"))
                for(int j = 0; j < i; j++)
                {
                    if(buffer.get(j).getBookType().equals(buffer.get(i).getBookType()))
                        System.out.print(buffer.get(j).getSenderName() + " notified of a "
                                         + buffer.get(j).getBookType() + " book from " + buffer.get(i).getSenderName() + "\n");
                }
        }
    }
}
