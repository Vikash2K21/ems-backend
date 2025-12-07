package com.vikash.ems.service.impl;

import com.vikash.ems.dto.EmployeeDto;
import com.vikash.ems.entity.Employee;
import com.vikash.ems.exception.ResourceNotFoundException;
import com.vikash.ems.mapper.EmployeeMapper;
import com.vikash.ems.repository.EmployeeRepository;
import com.vikash.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee =  employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResolutionException("Employee is not exists with given id : " +employeeId ));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employee -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                 ()->new ResourceNotFoundException("Employee is not exists with given id: " + employeeId)
         );

//        Updated feild
        employee.setName(updatedEmployee.getName());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setMobno(updatedEmployee.getMobno());
        employee.setDepartment(updatedEmployee.getDepartment());
        employee.setDesignation(updatedEmployee.getDesignation());
        employee.setSalary(updatedEmployee.getSalary());
        employee.setJoinDate(updatedEmployee.getJoinDate());

        Employee updatedEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                ()->new ResourceNotFoundException("Employee is not exists with given id: " + employeeId)
        );

        employeeRepository.deleteById(employeeId);
    }
}
