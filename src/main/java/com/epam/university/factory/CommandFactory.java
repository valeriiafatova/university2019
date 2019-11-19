package com.epam.university.factory;

import com.epam.university.web.command.Command;
import com.epam.university.web.command.CourseCommand;
import com.epam.university.web.command.LanguageCommand;
import com.epam.university.web.command.LoginCommand;
import com.epam.university.web.command.LogoutCommand;
import com.epam.university.web.command.RegistrationCommand;
import com.epam.university.web.command.admin.AdminCommand;
import com.epam.university.web.command.admin.NotificationCommand;
import com.epam.university.web.command.common.RatingCommand;
import com.epam.university.web.command.pages.AboutUsCommand;
import com.epam.university.web.command.pages.BlogCommand;
import com.epam.university.web.command.pages.BlogDetail;
import com.epam.university.web.command.pages.ContactCommand;
import com.epam.university.web.command.pages.HomeCommand;
import com.epam.university.web.command.pages.NotFoundCommand;
import com.epam.university.web.command.pages.SearchCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static Map<String, Command> getCommandMap = new HashMap<>();
    private static Map<String, Command> postCommandMap = new HashMap<>();
    private static Command defaultCommand = new NotFoundCommand();

    static {
        getCommandMap.put("/", new HomeCommand());
        getCommandMap.put("/404", defaultCommand);
        getCommandMap.put("/courses", new CourseCommand());
        getCommandMap.put("/blog", new BlogCommand());
        getCommandMap.put("/single-blog", new BlogDetail());
        getCommandMap.put("/contact", new ContactCommand());
        getCommandMap.put("/search", new SearchCommand());
        getCommandMap.put("/about-us", new AboutUsCommand());
        getCommandMap.put("/language", new LanguageCommand());
        getCommandMap.put("/logout", new LogoutCommand());
        getCommandMap.put("/registration", new RegistrationCommand());
        
        getCommandMap.put("/admin", new AdminCommand());
        getCommandMap.put("/notification", new NotificationCommand());
        getCommandMap.put("/rating", new RatingCommand());
        
        postCommandMap.put("/", new HomeCommand());
        postCommandMap.put("/login", new LoginCommand());
        postCommandMap.put("/registration", new RegistrationCommand());
        
        postCommandMap.put("/admin", new AdminCommand());
        postCommandMap.put("/notification", new NotificationCommand());
        postCommandMap.put("/rating", new RatingCommand());
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
