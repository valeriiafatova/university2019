package com.epam.university.security;

import com.epam.university.entity.User;
import com.epam.university.enums.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecurityConfig {

    private static Map<Role, List<String>> securityPages = new HashMap<>();

    static {
        securityPages.put(Role.ADMIN, Arrays.asList("/admin", "/rating", "/notification"));
        securityPages.put(Role.STUDENT, Arrays.asList("/rating"));
        securityPages.put(Role.LECTURER, Arrays.asList("/rating"));
    }

    public static boolean isSecurePage(String page) {
        return securityPages.values().stream()
                .anyMatch(list -> list.stream()
                        .anyMatch(pageValue -> pageValue.equals(page)));
    }

    public static boolean hasPermission(String page, Role role) {
        return securityPages.getOrDefault(role, Collections.EMPTY_LIST)
                .stream()
                .anyMatch(securePage -> securePage.equals(page));
    }
    
    public static boolean hasPermission(HttpServletRequest request, Role role){
        User currentUser = getCurrentUser(request);
        return currentUser != null && currentUser.getRole().equals(role);
    }
    
    public static User getCurrentUser(HttpServletRequest request){
        return (User) request.getSession().getAttribute("user");
    }

}
