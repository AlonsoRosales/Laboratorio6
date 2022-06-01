package com.example.lab6.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Pregunta1 {



    @GetMapping("")
    public String home(){
        return "pregunta1";
    }




}
