package util;
import java.util.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import dataObjects.eventItem;

/* Author: Kenneth Smith 4/19/2013
 * Java class to represent the event queue and act as the "message broker"
 * for the publisher/subscriber architecture for a library system.
 */

public class eventBuffer
{
    private List<eventItem> buffer;     //Arraylist to represent event queue
    private FileWriter myFileWriter;    //FileWriter to passing output to text file
    private PrintWriter myWriter;       //PrintWriter to pass formated output to FileWriter
    
    //eventBuffer constructor
    public eventBuffer(File myFile) throws IOException
    {
        buffer = new ArrayList<eventItem>();
        buffer.clear();
        myFileWriter = new FileWriter(myFile.getAbsoluteFile());
        myWriter = new PrintWriter(myFileWriter);
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
    public void dispatchEvents()  throws IOException
    {
        subscriber temp;                                                                 //Subscriber variable to access non-interfaced subscriber functions
        
        for(int i = 0; i < buffer.size(); i++)                                           //Iterate through arraylist to find publisher event
        {
            if(buffer.get(i).getEventType().equals("publisher"))                         //Check current event's class type
            {
                for(int j = 0; j < i; j++)                                               //Iterate through arraylist from beginning to current publisher event
                {
                    if(buffer.get(j).getBookType().equals(buffer.get(i).getBookType()))  //If subscriber book type = publisher book type
                    {
                        buffer.get(i).bufferMessage(buffer.get(j));                      // Notify subscriber
                        temp = (subscriber)buffer.get(j);                                // Get subscriber's notification confirmation message                           
                        myWriter.println(temp.getNoticeMessage());                       // Write output to text file
                    }
                }
            }
        }
        
        myWriter.close();                                                                //Close output text file
    }
}
    
