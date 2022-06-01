package com.example.lab6.Repository;

import com.example.lab6.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeReporsitory extends JpaRepository<Employee, Integer> {
}
