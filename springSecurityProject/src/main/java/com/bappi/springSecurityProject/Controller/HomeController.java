package com.bappi.springSecurityProject.Controller;


import com.bappi.springSecurityProject.model.Student;
import com.bappi.springSecurityProject.model.Users;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController
{
    @GetMapping("/")
    public String home(HttpServletRequest request)
    {
        return "This is my Home page : " + request.getSession().getId();
    }

//    @PostMapping("/")
//    public Users addUser()
//    {
//        return addUser(User User);
//    }


    @GetMapping("/students")
    public List<Student> getStudents()
    {
        List<Student> studentList = new ArrayList<>(List.of(
                new Student(1,"Rakesh",60),
                new Student(2,"Akash",70)));
                return studentList;
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request)
    {
        return (CsrfToken)request.getAttribute("_csrf");
    }
}
