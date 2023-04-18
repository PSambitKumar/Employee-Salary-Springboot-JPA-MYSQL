package com.csm.employeesalary.model;

import javax.persistence.*;

/**
 * @Project : GoldJewelleryPriceCalculator
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 18/04/2023 - 4:51 PM
 */
@Entity
@Table(name = "salary_table")
public class Salary {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer salaryId;
    @Column
    private Integer employeeId;
    @Column
    private String month;
    @Column
    private Integer year;
    @Column
    private Double employeeSalary;
    @Column
    private Double pf;
    @Column
    private Double hra;
    @Column
    private Double da;
    @Column
    private Double ta;
    @Column
    private Double deduction;
    @Column
    private Double netSalary;

    public Integer getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Integer salaryId) {
        this.salaryId = salaryId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public Double getPf() {
        return pf;
    }

    public void setPf(Double pf) {
        this.pf = pf;
    }

    public Double getHra() {
        return hra;
    }

    public void setHra(Double hra) {
        this.hra = hra;
    }

    public Double getDa() {
        return da;
    }

    public void setDa(Double da) {
        this.da = da;
    }

    public Double getTa() {
        return ta;
    }

    public void setTa(Double ta) {
        this.ta = ta;
    }

    public Double getDeduction() {
        return deduction;
    }

    public void setDeduction(Double deduction) {
        this.deduction = deduction;
    }

    public Double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(Double netSalary) {
        this.netSalary = netSalary;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "salaryId=" + salaryId +
                ", employeeId=" + employeeId +
                ", month='" + month + '\'' +
                ", year=" + year +
                ", employeeSalary=" + employeeSalary +
                ", pf=" + pf +
                ", hra=" + hra +
                ", da=" + da +
                ", ta=" + ta +
                ", deduction=" + deduction +
                ", netSalary=" + netSalary +
                '}';
    }
}
