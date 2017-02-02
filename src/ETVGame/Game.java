package ETVGame;

import java.util.Scanner;


public class Game 
{
    Scanner input=new Scanner(System.in);
    private Parser parser;
    private Room currentRoom;
    public Game(){
        createRooms();
        parser = new Parser();
    }

    private void createRooms(){
        Room etvhq, corridor, pub, lab, tvstation;
      
        etvhq = new Room("at the ETV headquarter.");
        corridor = new Room("in the corridor at the ETV headquarter.");
        tvstation = new Room("at the TV station. Congratulations!");
        
        etvhq.setExit("east", corridor);

        corridor.setExit("west", etvhq);

        currentRoom = etvhq;
    }

    public void play(){            
        printWelcome();
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome(){
        System.out.println("Welcome to the ETV Game. Oh, and if you need any help, type '" + CommandWord.HELP + "' ");
        System.out.println("Skittles has nothing better to do and he'll be right over!");
        System.out.print("Press 'ENTER' to start the game.");
        String start = input.nextLine ();
        System.out.println("COCOA: Noc, how was your weekend?");
        System.out.println();                   // Empty line.
        System.out.println("NOC: Good N*GGA! And you?");
        System.out.println();                   // Empty line.
        System.out.println("COCOA: Oh, it was just UN-BE-LIEVABLE! Thanks for asking!");
        System.out.println("By the way, meet me in the conference room at about 4 PM. ");
        System.out.println("I wanna talk to you and Chase.");
        System.out.println();                   // Empty line.
        System.out.println("COCOA: Zeus, my man.");
        System.out.println();                   // Empty line.
        System.out.println("ZEUS: What's up Cocoa?");
        System.out.println();                   // Empty line.
        System.out.println("COCOA: Call me K.O., Zeus. Call me K.O.");
        System.out.println();                   // Empty line.
        System.out.println("COCOA: Hey Checkerface, those white and blacks are looking extra defined today.");
        System.out.println();                   // Empty line.
        System.out.println("CHECKERFACE: Uh-, uh- you're looking pretty sexy yourself, boss!");
        System.out.println();                   // Empty line.
        System.out.println("COCOA: Thanks, I guess.");
        System.out.println();                   // Empty line.
        System.out.println("COCOA: Skittles!!! Go fuck yourself.");
        System.out.println();                   // Empty line.
        System.out.println("SKITTLES: Right back atcha', boss!");
        System.out.println();                   // Empty line.
        System.out.println("COCOA: Where's Chase?");
        System.out.println();                   // Empty line.
        System.out.println("SKITTLES: He's upstairs playing a game, as usual.");
        
        
        // Change of scene
        
        System.out.println("COCOA goes upstairs.");
        System.out.println();                   // Empty line.
        System.out.println("COCOA: Chase, my man, your show is killing it!");
        System.out.println();                   // Empty line.
        System.out.println("CHASE: Thanks, K.O.");
        System.out.println();                   // Empty line.
        System.out.println("COCOA: No, thank YOU. You're doing 80 times as much as Skittles ever did.");
        System.out.println("I basically just wanted to tell you that you and Noc are my two main men");
        System.out.println("and I want to have a meeting with the both of you later. Conference room at 4 P.M.");
        System.out.println();                   // Empty line.
        System.out.println("COCOA: I'll see you then.");
        
        
        //change of scene
        
        
        System.out.println("");
        
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
     
    }
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("NOC: Ion know what you mean, f*ggot as* n*gga. Try again.");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }
 
    private void printHelp(){
        System.out.println("Your phone's battery is dead.");
        System.out.println("You have no idea where you are.");
        System.out.println();
        System.out.println("However, your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command){
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door there, cuh!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }
    
    
    private boolean quit(Command command){
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }
}
