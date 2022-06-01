package com.example.lab6.Repository;

import com.example.lab6.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

import java.util.List;

@Repository
public interface EmployeeReporsitory extends JpaRepository<Employee, Integer> {
    @Query(nativeQuery = true,value = "call buscar_empleadosxmasanios(?1)")
    List<Employee> buscarEmpleadoPorMayorSalario(int salario);
    @Query(nativeQuery = true,value = "call buscar_empleadosxmasanios()")
    List<EmpleadoHistorialDTO> buscarEmpleadorPorAnios();
    @Query(nativeQuery = true,value = "SELECT * FROM hr.employees WHERE hr.employees.department_id = 60;" )
    List<Employee> empleadosIT();
}
