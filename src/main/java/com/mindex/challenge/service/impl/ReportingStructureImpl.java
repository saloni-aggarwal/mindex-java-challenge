package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;

@Service
public class ReportingStructureImpl implements ReportingStructureService {


    @Autowired
    private EmployeeService employeeService;

    @Override
    public ReportingStructure read(String employeeId) {

        Employee employee = employeeService.read(employeeId);
        int totalReps = employeeService.totalReports(employeeId);

        ReportingStructure reportingStructure = new ReportingStructure(employee, totalReps);

        return reportingStructure;
    }
}