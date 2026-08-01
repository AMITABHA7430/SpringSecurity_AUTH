package com.sequrityS.SpringSecurity;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class studentController {
    private List<Student> student = new ArrayList<>(List.of(
            new Student(1,"amitabha",89),
            new Student(2,"rahul",98)
    ));




    @GetMapping("/students")
    public List<Student> getStudents(){
        return student;
    }
    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");

    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student1){
        student.add(student1);
        return student1;
    }
}
