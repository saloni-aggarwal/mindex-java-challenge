package com.mindex.challenge.data;

import java.util.Objects;
import java.time.Instant;

public class Compensation {
    private Employee employee;
    private int salary;
    private String effectiveDate;
    private Instant effectiveDate;

    public Compensation() {
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public int getSalary() {
        return this.salary;
    }

    public String getEffectiveDate() {
        return this.effectiveDate;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

}