package com.example.lab6.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PreguntasController {



    @GetMapping("/Pregunta1a")
    public String preguntita1a(){
        return "pregunta1a";
    }

    @GetMapping("/Pregunta1b")
    public String preguntita1b(){
        return "pregunta1b";
    }

    @GetMapping("/Pregunta2a")
    public String preguntita2a(){
        return "pregunta2a";
    }

    @GetMapping("/Pregunta2b")
    public String preguntita2b(){
        return "pregunta2b";
    }


}
