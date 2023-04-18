package com.csm.employeesalary.repository;

import com.csm.employeesalary.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SalaryRepository extends JpaRepository<Salary, Integer> {
    @Query(value = "FROM Salary s WHERE s.employeeId = ?1 AND s.month = ?2")
    Salary getSalaryByEmployeeIdAndMonth(int employeeId, String month);
}