package cse460_progassign_kcsmith4;
import java.util.*;
import java.io.IOException;
import java.io.FileInputStream;


public class CSE460_ProgAssign_kcsmith4
{
    public static void main(String[] args) throws IOException
    {
        if(args.length < 1)
        {
            System.out.println("Error, usage: java ClassName inputfile");
            System.exit(1);
        }
        
        Scanner reader = new Scanner(new FileInputStream(args[0]));
        while(reader.hasNext())
            System.out.print(reader.next() + "\n");
    }
}
