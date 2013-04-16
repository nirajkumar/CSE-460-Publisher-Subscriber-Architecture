package dataObjects;
import java.util.*;


/*  Author: Kenneth Smith 4/11/2013
 *  Java object to model events for the publisher/subscriber architecture
 *  assignment.
 */

public class eventItem 
{
    private String _eventType;      //String representation of the event type, either a publisher or a subscriber
    private String _senderName;     //String representation of the sender's identifaction
    private String _bookType;       //String representation of the requested book's topic
    
    public eventItem(String eType, String sName, String bType)
    {
        this._eventType = eType;
        this._senderName = sName;
        this._bookType = bType;
    }
    
    //Returns this event's type, either publisher or subscriber
    public String getEventType()
    {
        return this._eventType;
    }
    
    //Returns the ID for the sender of this event
    public String getSenderName()
    {
        return this._senderName;
    }
    
    //Returns the book topic for this event
    public String getBookType()
    {
        return this._bookType;
    }
}
