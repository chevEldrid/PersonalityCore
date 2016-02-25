import java.io.*;
import java.util.*;

public class Parser implements Serializable
{
    private int commandNum=-1;
    //inputted command
    private String command="";
    //rest of input after command taken out
    private String commandObject="";
    
    //parser for prompt
    //constructor assigns values to commandNumber, command, commandObject
    public Parser()
    {    
       
    }
    public void parse(String input, ArrayList<String> commandArray)
    {
        Scanner parser=new Scanner(input);
        //clears all old command stuff
        commandNum=-1; //initial value so if input is not found in commandArray, method returns a -1
        command="";
        commandObject="";
        
        //takes the first word of input as potential command
        command=parser.next();
        do
        {
            for(int i=0; i<commandArray.size();i++) //checks @command against entire @commandArray...
            {
                if (command.equalsIgnoreCase(commandArray.get(i))) //if @command is in @commandArray...
                {
                    commandNum=i; //sets @commandNum to index of @command in @commandArray
                    while(parser.hasNext()) //takes the rest of the @input as a second variable
                        commandObject+=" "+parser.next();
                    if(!(commandObject.equals(""))) //removes the extra space left at beginning of @commandObject
                        commandObject=commandObject.substring(1);
                    break;
                }
            }
            if(parser.hasNext()) //if @command is not present in @commandArray, the next word of @input is added to original @command
                command+=" "+parser.next();
        }while(parser.hasNext());
        for(int i=0; i<commandArray.size();i++) //should the command be multi-word and make up all of @input, this last loop checks it
        {
            if (command.equalsIgnoreCase(commandArray.get(i)))
            {
                commandNum=i;
                break;
            }
        }
    }
    public int getCommandNum()
    {
        return commandNum;
    }
    public String getCommand()
    {
        return command;
    }
    public String getCommandObject()
    {
        return commandObject;
    }
    //able to be used by any class to return a coherent string from user input from a given prompt
    public static String getText(String prompt)
    {
        String text="";
        String input="";
        Scanner trojan = new Scanner(System.in);
        do
        {
            System.out.println(prompt);
            input = trojan.nextLine();
        }while(input.equals(""));
        
        Scanner parser = new Scanner(input);
        if(parser.hasNext())
            text+=parser.next();
        while(parser.hasNext())
            text+=" "+parser.next();
        System.out.println(); //just for spacing
        return text;
    }
}