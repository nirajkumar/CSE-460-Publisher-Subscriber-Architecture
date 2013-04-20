package util;
import java.util.*;
import dataObjects.eventItem;
import util.subscriber;

/* Author: Kenneth Smith 4/19/2013
 * Java class to represent the publisher in a publisher/subscriber
 * architecture for a library system.
 */

public class publisher implements eventItem
{
    private String _sender;     //Publisher name
    private String _bookType;   //Type of book checked into library
    
    public publisher(String sender, String book)
    {
        this._sender = sender;
        this._bookType = book;
    }
    
    //Return the eventItem's interface class
    public String getEventType()
    {
        return "publisher";
    }
    
    //Return the publisher's name
    public String getSenderName()
    {
        return this._sender;
    }
    
    //Return the book type checked into the library
    public String getBookType()
    {
        return this._bookType;
    }
    
    //Notify subscriber requesting book
    public void bufferMessage(eventItem event)
    {
        event.bufferMessage(this);
    }
}
