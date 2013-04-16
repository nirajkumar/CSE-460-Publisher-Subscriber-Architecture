package util;
import java.util.*;
import dataObjects.eventItem;

public class eventBuffer
{
    private List<eventItem> buffer;
    
    public eventBuffer()
    {
        buffer = new ArrayList<eventItem>();
        buffer.clear();
    }
    
    public void addEvent(eventItem newEvent)
    {
        buffer.add(newEvent);
    }
    
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
