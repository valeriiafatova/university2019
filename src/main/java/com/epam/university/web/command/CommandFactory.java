package com.epam.university.web.command;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory  {
   private static Map<String, Command> commandMap = new HashMap<>();
   private static Map<String, Command> getCommandMap = new HashMap<>();
   private static Map<String, Command> postCommandMap = new HashMap<>();
    
    static {
        commandMap.put("user", new UserCommand());
    }
    
   public static Command getCommand(String path){
        return getCommandMap.get(path);
    }

    public static Command postCommand(String path){
        return postCommandMap.get(path);
    }
}
