package com.example.lab6.Controllers;

import com.example.lab6.Entity.EmpleadoHistorialDTO;
import com.example.lab6.Entity.Employee;
import com.example.lab6.Repository.EmployeeReporsitory;
import com.example.lab6.Repository.JobReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/Lab6")
public class PreguntasController {

    @Autowired
    EmployeeReporsitory employeeReporsitory;
    @Autowired
    JobReporsitory jobReporsitory;

    @GetMapping("/Pregunta1")
    public String pregunta1(Model model) {
        List<Employee> employeeList = employeeReporsitory.findAll();
        model.addAttribute("listaEmpleados",employeeList);
        return "pregunta1a";
    }

    @GetMapping("/Pregunta1a")
    public String preguntita1a(Model model, @RequestParam(value = "monto",defaultValue = "0") String monto){
        try{
            Integer monto_value = Integer.parseInt(monto);
            List<Employee> employeeList = employeeReporsitory.buscarEmpleadoPorMayorSalario(monto_value);
            model.addAttribute("listaEmpleados",employeeList);
        }catch (Exception e){
            e.printStackTrace();
            List<Employee> employeeList = employeeReporsitory.findAll();
            model.addAttribute("listaEmpleados",employeeList);
            model.addAttribute("msg","Hubo un error");
        }
        return "pregunta1a";
    }

    @GetMapping("/Pregunta1b")
    public String preguntita1b(Model model){
        List<EmpleadoHistorialDTO> empleadoHistorialDTOS = employeeReporsitory.buscarEmpleadorPorAnios();
        model.addAttribute("listaEmpleados",empleadoHistorialDTOS);
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
