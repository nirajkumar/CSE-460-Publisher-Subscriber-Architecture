package util;
import java.util.*;
import dataObjects.eventItem;
import java.io.PrintWriter;

/* Author: Kenneth Smith 4/19/2013
 * Java class to represent the subscriber in a publisher/subscriber
 * architecture for a library system.
 */

public class subscriber implements eventItem
{
    private String _sender;             //Subscriber's name 
    private String _bookType;           //Book type requested by the subscriber
    private String _message;            //Notification message of publisher event for this subscriber
    private PrintWriter _myWriter;      //PrintWriter to write subscriber's notification message to output text file constructed in main class  
    
    public subscriber(String sender, String book, PrintWriter outputWriter)
    {
        this._sender = sender;
        this._bookType = book;
        this._message = "";
        this._myWriter = outputWriter;
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
    
    //Writes notification message to a text file
    public void writeOutput()
    {
        _myWriter.println(_message);
    }
    
    //Recieve notice from publisher that the requested book has been checked in
    public void bufferMessage(String publisherName)
    {
       _message = this.getSenderName() + " notified of a " + this.getBookType()
                        + " book from " + publisherName;
       writeOutput();
    }
}
