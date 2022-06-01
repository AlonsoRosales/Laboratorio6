package com.example.lab6.Controllers;

import com.example.lab6.Entity.Employee;
import com.example.lab6.Repository.DepartmentRepository;
import com.example.lab6.Repository.EmployeeReporsitory;
import com.example.lab6.Repository.JobReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class PreguntasController {

    @Autowired
    EmployeeReporsitory employeeReporsitory;
    @Autowired
    JobReporsitory jobReporsitory;
    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("/Pregunta1")
    public String pregunta1(Model model) {
        List<Employee> employeeList = employeeReporsitory.findAll();
        model.addAttribute("list","listaEmpleados");
        return "pregunta1";
    }

    @GetMapping("")
    public String home(){
        return "casita";
    }

    @GetMapping("/Pregunta1a")
    public String preguntita1a(Model model){
        return "pregunta1a";
    }

    @GetMapping("/Pregunta1b")
    public String preguntita1b(){
        return "pregunta1b";
    }

    @GetMapping("/Pregunta2a")
    public String preguntita2a(@RequestParam(value = "id", defaultValue = "0") String strId,
                               Model model){
        try{
            int idEmpleado = Integer.parseInt(strId);

            Optional<Employee> empleadoSelect = employeeReporsitory.findById(idEmpleado);

            if(empleadoSelect.isPresent()){
                Integer impuestos = employeeReporsitory.hallarImpuestos(idEmpleado);
                model.addAttribute("empleadoSelect",empleadoSelect.get());
                model.addAttribute("impuestos",impuestos);
            }
        } catch (NumberFormatException e){
            System.out.println("La id recibida es: " + strId);
        }

        model.addAttribute("listaEmpleados",employeeReporsitory.findAll());
        return "pregunta2a";
    }

    @PostMapping("/Pregunta2a/calcular")
    public String p2aCalcular(@RequestParam("id") String idEmpleado){
        return "redirect:/Pregunta2a?id="+idEmpleado;
    }

    @GetMapping("/Pregunta2b/list")
    public String preguntita2b(Model model){
        model.addAttribute("listaEmpleados",employeeReporsitory.empleadosIT());
        return "pregunta2b/list";
    }
    @GetMapping("/Pregunta2b/new")
    public String crearNuevoEmpleado(Model model){
        model.addAttribute("listaTrabajos",jobReporsitory.findAll());
        model.addAttribute("listaDepartamentos",departmentRepository.findAll());
        return "pregunta2b/newForm";
    }
    @PostMapping("/Pregunta2b/save")
    public String guardarEmpleado(Employee employee, @RequestParam("salarystr") String salarystr){
        BigDecimal salary = new BigDecimal(salarystr);
        employee.setSalary(salary);
        employeeReporsitory.save(employee);
        return "redirect:/Lab6/Pregunta2b/list";
    }



}
