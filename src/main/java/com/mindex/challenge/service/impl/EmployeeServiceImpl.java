package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        LOG.debug("Creating employee [{}]", employee);

        employee.setEmployeeId(UUID.randomUUID().toString());
        employeeRepository.insert(employee);

        return employee;
    }

    @Override
    public Employee read(String id) {
        LOG.debug("Creating employee with id [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        LOG.debug("Updating employee [{}]", employee);

        return employeeRepository.save(employee);
    }

    /**
     * This function finds the number of reports for an employee using DFS
     * @param employeeId   id of the employee
     * @return   number of report
     */
    @Override
    public int totalReports(String employeeId) {
        //Count to store number of reports
        int totalCount = 0;
        //Getting employee details by id
        Employee employee = this.read(employeeId);
        //Storing all reports of employee
        List<Employee> reportees = employee.getDirectReports();
        //If there are reports for an employee then traversing the list
        //to find all reports of employee in list by dfs
        if(reportees != null) {
            for(Employee e: reportees)
                totalCount += 1 + totalReports(e.getEmployeeId());
        }
        return totalCount;
    }
}
