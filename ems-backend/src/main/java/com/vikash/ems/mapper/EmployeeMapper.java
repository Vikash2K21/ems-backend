package com.vikash.ems.mapper;

import com.vikash.ems.dto.EmployeeDto;
import com.vikash.ems.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getMobno(),
                employee.getDepartment(),
                employee.getDesignation(),
                employee.getSalary(),
                employee.getJoinDate()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getName(),
                employeeDto.getEmail(),
                employeeDto.getMobno(),
                employeeDto.getDepartment(),
                employeeDto.getDesignation(),
                employeeDto.getSalary(),
                employeeDto.getJoinDate()
        );
    }
}
