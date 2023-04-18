package com.csm.employeesalary.repository;

import com.csm.employeesalary.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee getEmployeeByEmployeeId(int employeeId);
}