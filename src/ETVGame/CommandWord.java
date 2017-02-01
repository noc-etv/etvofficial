package ETVGame;

 public enum CommandWord{
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), START("start");
    
    private String commandString;
    
    CommandWord(String commandString){
        this.commandString = commandString;
    }
    
    public String toString(){
        return commandString;
    }
}
