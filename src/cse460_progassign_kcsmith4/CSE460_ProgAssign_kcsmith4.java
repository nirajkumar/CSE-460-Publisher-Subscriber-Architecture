package cse460_progassign_kcsmith4;
import java.util.*;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileWriter;
import dataObjects.eventItem;
import util.eventBuffer;

public class CSE460_ProgAssign_kcsmith4
{
    public static void main(String[] args) throws IOException
    {
        eventBuffer libraryBuffer = new eventBuffer();
        eventItem newEvent;
        String[] tokens;
        
        if(args.length < 1)
        {
            System.out.println("Error, usage: java ClassName inputfile");
            System.exit(1);
        }
        
        Scanner reader = new Scanner(new FileInputStream(args[0]));
        while(reader.hasNext())
        {
            tokens = reader.next().split(",");
            newEvent = new eventItem(tokens[0], tokens[1], tokens[2]);
            libraryBuffer.addEvent(newEvent);
        }
        
        libraryBuffer.dispatchEvents();
    }
}
