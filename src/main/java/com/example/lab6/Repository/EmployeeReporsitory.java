package com.example.lab6.Repository;

import com.example.lab6.Entity.EmpleadoHistorialDTO;
import com.example.lab6.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EmployeeReporsitory extends JpaRepository<Employee, Integer> {
    @Query(nativeQuery = true,value = "call buscar_empleadosxmasanios(?1)")
    List<Employee> buscarEmpleadoPorMayorSalario(int salario);
    @Query(nativeQuery = true,value = "call buscar_empleadosxmasanios()")
    List<EmpleadoHistorialDTO> buscarEmpleadorPorAnios();
}
