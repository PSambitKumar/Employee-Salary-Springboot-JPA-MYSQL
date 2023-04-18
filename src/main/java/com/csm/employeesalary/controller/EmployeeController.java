package com.csm.employeesalary.controller;

import com.csm.employeesalary.model.Employee;
import com.csm.employeesalary.model.Salary;
import com.csm.employeesalary.repository.EmployeeRepository;
import com.csm.employeesalary.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Project : GoldJewelleryPriceCalculator
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 18/04/2023 - 4:42 PM
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private SalaryRepository salaryRepository;

    @GetMapping("/employee")
    public String index(Model model) {
        List<Employee> employeeList = employeeRepository.findAll();
        model.addAttribute("employeeList", employeeList);
        System.out.println("Inside Home");
        return "employee";
    }

    @ResponseBody
    @GetMapping("/getEmployeeDetails")
    public ResponseEntity getEmployeeDetails(@RequestParam(value = "employeeId") Integer employeeId) {
        System.out.println("Inside getEmployeeDetails");
        Employee employee = employeeRepository.getEmployeeByEmployeeId(employeeId);
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/employeeSalaryUpdate")
    public String employeeSalaryUpdate(@RequestParam(value = "employeeId", required = false) Integer employeeId,
                                       @RequestParam(value = "phoneNumber", required = false) String phoneNumber,
                                       @RequestParam(value = "salary", required = false) Double salary,
                                       @RequestParam(value = "pf", required = false) String pf,
                                       @RequestParam(value = "email", required = false) String email,
                                       @RequestParam(value = "hra", required = false) String hra,
                                       Model model) {
        System.out.println("Inside employeeSalaryUpdate");
        System.out.println("Employee Id: " + employeeId + " Phone Number: " + phoneNumber + " Salary: " + salary + " PF: " + pf + " Email: " + email + " HRA: " + hra);
        if (employeeId != null && phoneNumber != null && salary != null && pf != null && email != null && hra != null) {
            Employee employee = employeeRepository.getEmployeeByEmployeeId(employeeId);
            employee.setEmployeePhone(phoneNumber);
            employee.setEmployeeSalary(salary);
            employee.setPFPercentage(Integer.valueOf(pf));
            employee.setEmployeeEmail(email);
            employee.setHRAPercentage(Integer.valueOf(hra));
//            employeeRepository.save(employee);

            String prevMonth = new SimpleDateFormat("MMM").format(new Date(System.currentTimeMillis() - 2592000000L));

            Salary salaryEntity = salaryRepository.getSalaryByEmployeeIdAndMonth(employeeId, prevMonth.toUpperCase());
            salaryEntity.setEmployeeSalary(employee.getEmployeeSalary());
            salaryRepository.save(salaryEntity);

            model.addAttribute("message", "Salary Updated Successfully");
        }
        return "redirect:/employee";
    }
}
