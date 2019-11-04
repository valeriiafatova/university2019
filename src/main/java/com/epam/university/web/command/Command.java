package com.epam.university.web.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {
    
    void perform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    String perform(HttpServletRequest request) throws ServletException, IOException;
}
