package util;
import java.util.*;
import dataObjects.eventItem;

/* Author: Kenneth Smith 4/19/2013
 * Java class to represent the subscriber in a publisher/subscriber
 * architecture for a library system.
 */

public class subscriber implements eventItem
{
    private String _sender;     //Subscriber's name 
    private String _bookType;   //Book type requested by the subscriber
    private String _message;
    
    public subscriber(String sender, String book)
    {
        this._sender = sender;
        this._bookType = book;
        this._message = "";
    }
    
    //Return the eventItem's interface class
    public String getEventType()
    {
        return "subscriber";
    }
    
    //Return the subscriber's name
    public String getSenderName()
    {
        return this._sender;
    }
    
    //Return the book type requested by the subscriber
    public String getBookType()
    {
        return this._bookType;
    }
    
    //Returns notification of publisher event
    public String getNoticeMessage()
    {
        return this._message;
    }
    
    //Recieve notice from publisher that the requested book has been checked in
    public void bufferMessage(eventItem event)
    {
       _message = this.getSenderName() + " notified of a " + this.getBookType()
                        + " book from " + event.getSenderName();
    }
}
