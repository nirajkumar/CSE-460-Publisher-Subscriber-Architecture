package cse460_progassign_kcsmith4;
import java.util.*;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileWriter;
import dataObjects.eventItem;
import util.eventBuffer;
import util.publisher;
import util.subscriber;

/* Author: Kenneth Smith 4/19/2013
 * Driver program for the publisher/subscriber architecture assignment
 */

public class CSE460_ProgAssign_kcsmith4
{
    public static void main(String[] args) throws IOException
    {
        eventBuffer libraryBuffer = new eventBuffer();  //Instance of eventBuffer to act as message broker
        eventItem newEvent;                             //Temp instance of eventItem to represent each event
        String[] tokens;                                //Store tokens of each line of input, stores 1 line at a time
        
        //Check to make sure there is a command line arguement
        if(args.length < 1)
        {
            System.out.println("Error, usage: java " + CSE460_ProgAssign_kcsmith4.class.getSimpleName() + " inputfile");
            System.exit(1);
        }
        
        Scanner reader = new Scanner(new FileInputStream(args[0]));             //Read in all lines from command line input file
        while(reader.hasNext())
        {
            tokens = reader.next().split(",");                                  //Tokenize string using commas as a delimiter
            
            if(tokens[0].equals("Publish") || tokens[0].equals("publish"))      //if tokens[0] = "Publish" then create a new publisher object
              newEvent = new publisher(tokens[1], tokens[2]);          
            else                                                                //if tokens[0] = "Subscribe" then create a new subscriber object
              newEvent = new subscriber(tokens[1], tokens[2]);
            
            libraryBuffer.addEvent(newEvent);                                   //Add new event to the queue
        }
        
        libraryBuffer.dispatchEvents();                                         //Process event queue
    }
}
