package com.sequrityS.SpringSecurity;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmiController {

    @GetMapping("/")
    public String greet(HttpServletRequest request){
        return "hello Amitabha Ghosh"+ "\n"+request.getSession().getId();
    }

}
