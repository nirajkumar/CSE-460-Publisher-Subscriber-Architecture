package cse460_progassign_kcsmith4;
import java.util.*;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import util.eventBuffer;
import util.publisher;
import util.subscriber;
import dataObjects.eventItem;

/* Author: Kenneth Smith 4/19/2013
 * Driver program for the publisher/subscriber architecture assignment
 */

public class CSE460_ProgAssign_kcsmith4
{
    public static void main(String[] args) throws IOException
    {
        eventBuffer libraryBuffer;                       //Instance of eventBuffer to act as message broker
        eventItem newEvent;                              //Temp instance of eventItem to represent each event
        String[] tokens;                                 //Store tokens of each line of input, stores 1 line at a time
        File myFile;                                     //File for the output
        FileWriter myFileWriter;                         //FileWriter to passing output to text file
        PrintWriter myWriter;                            //PrintWriter to pass formated output to FileWriter
        
        //Check to make sure there is a command line arguement, if not throw error and exit
        if(args.length < 1)
        {
            System.out.println("Error, usage: java " + CSE460_ProgAssign_kcsmith4.class.getSimpleName() + " inputfile");
            System.exit(1);
        }
        
        Scanner reader = new Scanner(new FileInputStream(args[0]));             //Read in all lines from command line input file
        
        myFile = new File(args[1]);                                             //Set output file to command line output file
        if(!myFile.exists())                                                    //Check if command line output file exists
            myFile.createNewFile();                                             //If output file does not exist, create it
        
        myFileWriter = new FileWriter(myFile.getAbsoluteFile());                //Initialize FileWriter
        myWriter = new PrintWriter(myFileWriter);                               //Initialize PrintWriter
        libraryBuffer = new eventBuffer();                                      //Create new eventBuffer
        
        while(reader.hasNext())                                                 //Cycle through input text until EOF is found
        {
            tokens = reader.next().split(",");                                  //Tokenize string using commas as a delimiter
            
            if(tokens[0].equals("Publish") || tokens[0].equals("publish"))      //if tokens[0] = "Publish" then create a new publisher object
            {
                newEvent = new publisher(tokens[1], tokens[2]);                 
                libraryBuffer.dispatchEvent(newEvent);                          //Process publisher event
            }
            else
            {       
                newEvent = new subscriber(tokens[1], tokens[2], myWriter);      //if tokens[0] = "Subscribe" then create a new subscriber object
                libraryBuffer.addEvent(newEvent);                               //Add new subscriber event to the event pool
            }
        }
        
        myWriter.close();                                                       //Close Output stream                           
    }
}
