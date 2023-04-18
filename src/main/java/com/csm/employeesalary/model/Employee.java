package com.csm.employeesalary.model;

import javax.persistence.*;

/**
 * @Project : GoldJewelleryPriceCalculator
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 18/04/2023 - 4:44 PM
 */
@Entity
@Table(name = "employee_table")
public class Employee {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    @Column
    private String employeeName;
    @Column
    private String employeePhone;
    @Column
    private String employeeEmail;
    @Column
    private Double employeeSalary;
    @Column
    private Integer PFPercentage;
    @Column
    private Integer HRAPercentage;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public Integer getPFPercentage() {
        return PFPercentage;
    }

    public void setPFPercentage(Integer PFPercentage) {
        this.PFPercentage = PFPercentage;
    }

    public Integer getHRAPercentage() {
        return HRAPercentage;
    }

    public void setHRAPercentage(Integer HRAPercentage) {
        this.HRAPercentage = HRAPercentage;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeePhone='" + employeePhone + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeeSalary=" + employeeSalary +
                ", PFPercentage=" + PFPercentage +
                ", HRAPercentage=" + HRAPercentage +
                '}';
    }
}
