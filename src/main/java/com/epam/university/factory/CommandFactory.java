package com.epam.university.factory;

import com.epam.university.web.command.AboutUsCommand;
import com.epam.university.web.command.BlogCommand;
import com.epam.university.web.command.BlogDetail;
import com.epam.university.web.command.Command;
import com.epam.university.web.command.ContactCommand;
import com.epam.university.web.command.CourseCommand;
import com.epam.university.web.command.CourseDetailsCommand;
import com.epam.university.web.command.HomeCommand;
import com.epam.university.web.command.LanguageCommand;
import com.epam.university.web.command.LoginCommand;
import com.epam.university.web.command.LogoutCommand;
import com.epam.university.web.command.NotFoundCommand;
import com.epam.university.web.command.SearchCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static Map<String, Command> getCommandMap = new HashMap<>();
    private static Map<String, Command> postCommandMap = new HashMap<>();
    private static Command defaultCommand = new NotFoundCommand();

    static {
        getCommandMap.put("/", new HomeCommand());
        getCommandMap.put("/404", defaultCommand);
        getCommandMap.put("/course", new CourseCommand());
        getCommandMap.put("/course-details", new CourseDetailsCommand());
        getCommandMap.put("/blog", new BlogCommand());
        getCommandMap.put("/single-blog", new BlogDetail());
        getCommandMap.put("/contact", new ContactCommand());
        getCommandMap.put("/search", new SearchCommand());
        getCommandMap.put("/about-us", new AboutUsCommand());
        getCommandMap.put("/language", new LanguageCommand());
        getCommandMap.put("/logout", new LogoutCommand());
        
        postCommandMap.put("/", new HomeCommand());
        postCommandMap.put("/login", new LoginCommand());
    }

    private CommandFactory() {
    }

    public static Command getCommand(String path, String type) {
        return "GET".equals(type) 
                ? getCommand(path) 
                : postCommand(path);
    }

    private static Command getCommand(String path) {
        return getCommandMap.getOrDefault(path, defaultCommand);
    }

    private static Command postCommand(String path) {
        return postCommandMap.getOrDefault(path, defaultCommand);
    }
}
