package com.examples.microservices.webappserver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
		
    @GetMapping("")
    public String welcome() {
        return "index"; // return index.html as response
    }
    
    @GetMapping("/error")
    public String error() {
        return "error";
    }
}