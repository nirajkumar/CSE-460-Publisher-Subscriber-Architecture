package dataObjects;
import java.util.*;

/*  Author: Kenneth Smith 4/19/2013
 *  Java interface to model events for the publisher/subscriber architecture
 *  assignment.
 */

public interface eventItem 
{
    //Returns this event's type, either publisher or subscriber
    public String getEventType();
    
    //Returns the ID for the sender of this event
    public String getSenderName();
    
    //Returns the book topic for this event
    public String getBookType();
    
    //Notify subscriber of a publisher event
    public void bufferMessage(eventItem event);
}
