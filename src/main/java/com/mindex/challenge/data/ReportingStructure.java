package com.mindex.challenge.data;

public class ReportingStructure {
    private Employee employee;
    private int numberOfReports;

    public ReportingStructure(){ }

    /**
     * Constructor to load report objects with computed values
     * @param employee  Employee Object
     * @param numberOfReports   Total number of reports
     */
    public ReportingStructure(Employee employee, int numberOfReports){
        this.employee=employee;
        this.numberOfReports=numberOfReports;
    }

    public void setEmployee(Employee employee){ this.employee=employee; }

    public void setNumberOfReports(int reportCount){ this.numberOfReports=reportCount; }

    public Employee getEmployee(){ return employee; }

    public int getNumberOfReports(){ return numberOfReports; }

}