package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompensationServiceImpl implements CompensationService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CompensationRepository compensationRepository;

    /**
     * Creates and insert compensation for shared employee
     * @param compensation  Compensation Object
     * @return  Inserted Compensation
     */
    @Override
    public Compensation create(Compensation compensation) {
        //Get information of employee by id
        Employee employee = employeeService.read(compensation.getEmployee().getEmployeeId());
        //Setting the compensation of employee
        compensation.setEmployee(employee);
        //Inserting compensation in repository
        compensationRepository.insert(compensation);
        return compensation;
    }

    /**
     * Reads compensation for shared employeeId
     * @param id    EmployeeId
     * @return  Compensation Object for shared employeeId
     */
    @Override
    public Compensation read(String id) {
        //Get information of employee by id
        Employee employee = employeeService.read(id);
        //Finding compensation of the shared employee
        Compensation compensation = compensationRepository.findCompensationByEmployee(employee);

        //If null then throw an error
        if (compensation == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return compensation;
    }
}