import java.io.*;
import java.util.*;

public class Core implements Serializable, Dialogue
{
   //Commander from tech demo modified for Personality core software, core-ANGER
    //commands are housed in the commander class because there really aren't that many and they don't change
    public String[] baseCommands={"current location","give opinion","status update","travel to","OS info", "help","quit"};
    private ArrayList<String>commandArray = new ArrayList<String>(); //ArrayList of all possible commands to use in this room
    private ArrayList<PossibleAction> actionList=new ArrayList<PossibleAction>();
    private ArrayList<String> opinions=new ArrayList<String>();
    private ArrayList<String> statusUpdates=new ArrayList<String>();
    private ArrayList<String> travelDestinations=new ArrayList<String>();
    //current location
    private String location="Nowhere and Everywhere";
    //private Map<String, MTG>collection=new HashMap<String, MTG>();

    //--------------------------------------------------------------------------------
    //initial set-up of basic commands to run parrallel to @baseCommands
    //http://stackoverflow.com/questions/4280727/java-creating-an-array-of-methods
    interface PossibleAction extends Serializable
    {
        void act();
    }
    //must be in same order as commands in command array or...things will get freaky
    private PossibleAction[] possibleActions= new PossibleAction[] 
    {
        new PossibleAction() {public void act() {currentLocation(); } },
        new PossibleAction() {public void act() {giveOpinion(); } },
        new PossibleAction() {public void act() {statusUpdate(); } },
        new PossibleAction() {public void act() {travelTo(); } }, 
        new PossibleAction() {public void act() {osInfo(); } },
        new PossibleAction() {public void act() {help(); } },
        new PossibleAction() {public void act() {quit(); } },
    };
    //---------------------------------------------------------------------------------

    public static String input=""; //universal input //figure out if actually necessary somepoint soon---------------
    
    private Parser parsed; //holds the parser passed through in constructor

    public Core(Parser parsed)
    {
       this.parsed=parsed;
       for(String i: baseCommands) //sets @commandArray initially to simply the base commands
            commandArray.add(i);
        for(PossibleAction j: possibleActions) //sets @actionList initially to all base commands
            actionList.add(j);
        for(String i: opinionsOfAnger)
            opinions.add(i);
        for(String i: statusUpdatesOfAnger)
            statusUpdates.add(i);
        for(String i: planets)
            travelDestinations.add(i);
    }
    public Core(Parser parsed, String location)
    {
        this.parsed=parsed;
       for(String i: baseCommands) //sets @commandArray initially to simply the base commands
            commandArray.add(i);
        for(PossibleAction j: possibleActions) //sets @actionList initially to all base commands
            actionList.add(j);
        for(String i: opinionsOfAnger)
            opinions.add(i);
        for(String i: statusUpdatesOfAnger)
            statusUpdates.add(i);
        for(String i: planets)
            travelDestinations.add(i);
        this.location=location;
    }
    //the core-prompt
    public void prompt()
    {
        input=""; //resets input to empty string
        Scanner prompter = new Scanner(System.in); //initiates Scanner that will recieve user input
        System.out.println("\nWHAT DO YOU WANT NOW?!");
        input = prompter.nextLine();
        while(input.equals("")) //just to catch people from slogging up the game
        {
            System.out.println("LOOK, I DON'T HAVE ALL DAY \n \n What do you WANT?");
            input=prompter.nextLine();
        }
		parsed.parse(input, commandArray); //calls the parse() method of the Parser @parsed which takes a string and a list of commands, cross-referencing the string to see if what the user inputted is a valid command
        input=parsed.getCommandObject(); //if any of the user input was not part of the command itself, it is stored here
        commandInterpretor(parsed.getCommandNum(),commandArray); //sends the commandInterpretor() the command number of the commanArray and the array of possible commands itself (initial array is sent just as a safety measure)
    }
    public void commandInterpretor(int commandToRun, ArrayList<String> commandArray)
    {
        System.out.println();
        if(commandToRun<commandArray.size() && commandToRun>=0)
            actionList.get(commandToRun).act(); //runs the correct interface which in turn runs a singular method based on position of command in command array
        else
        {
            System.out.println("REAL mature, try to outsmart the robot huh? Bare in mind that I control life support on this vessel... \nType something valid, would ya? OR ASK FOR \"help\"!");
        }
    }
    public void currentLocation()
    {
        System.out.println("YOU ARE STILL AT "+location);
    }

    public void giveOpinion()
    {
        //System.out.println(opinions.size());
        int opinion=(int)(Math.random()*opinions.size());
        //System.out.println(opinion);
        System.out.println(opinions.get(opinion));
    }
    public void statusUpdate()
    {
        System.out.println(statusUpdates.get((int)(Math.random()*statusUpdates.size())));
    }
    public void travelTo()
    {
        boolean temp=true;
        for(String i: travelDestinations)
        {
            if(input.equalsIgnoreCase(i))
            {
                temp=false;
                location=i;
                System.out.println(planetResp[travelDestinations.indexOf(i)]);
                break;
            }
        }
        if(temp)
        {    
            System.out.println("HAH HAH. I have NO idea where that is so GO FIND IT ON YOUR OWN TIME! \n I will only take you to THESE PLACES:");
            for(String i: travelDestinations)
                System.out.println(i);
        }
    }
     public void osInfo()
    {
        System.out.println("MY NAME IS STEVE, \nA prototype of Sirius Cybernetics Corporation's GPP (Genuine People Personalities)\n AND I ATE EDDIE. FEAR ME.\n(System version 0000002)");
    }
    public void help()
    {
        System.out.println("I CAN DO THESE THINGS. ANYTHING ELSE, YOU'RE ON YOUR OWN:");
        for(int x=0;x<commandArray.size();x++)
            System.out.println(commandArray.get(x));
        System.out.println("\nFor further aide, please check out ye olde pdf bundled with the software. \n WHICH I BURNT CAUSE IT WAS DUMB.");
    }
    public void quit()
    {
        Scanner quitter=new Scanner(System.in);
        System.out.println("QUIT! GIVE UP! DO IT!...[y/n]");
        String decision=quitter.next();
        if(decision.equalsIgnoreCase("y"))
            System.exit(0);
        else if(decision.equalsIgnoreCase("n"))
            System.out.println("Yeah, that's what we thought.\n");
        else
            System.out.println("REAL FUNNY.\n");
    }
}