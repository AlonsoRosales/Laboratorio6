package com.example.lab6.Controllers;

import com.example.lab6.Entity.Employee;
import com.example.lab6.Repository.EmployeeReporsitory;
import com.example.lab6.Repository.JobReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class PreguntasController {

    @Autowired
    EmployeeReporsitory employeeReporsitory;
    @Autowired
    JobReporsitory jobReporsitory;

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

    @GetMapping("/Pregunta2b/list")
    public String preguntita2b(Model model){
        model.addAttribute("listaEmpleados",employeeReporsitory.empleadosIT());
        return "pregunta2b/list";
    }
    @GetMapping("/Pregunta2b/new")
    public String crearNuevoEmpleado(Model model){
        model.addAttribute("listaTrabajos",jobReporsitory.findAll());
        return "pregunta2b/newForm";
    }
    @PostMapping("/Pregunta2b/save")
    public String guardarEmpleado(Employee employee){
        employeeReporsitory.save(employee);
        return "redirect:/pregunta2b/list";
    }



}
