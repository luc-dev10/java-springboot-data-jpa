package com.lucio.springboot.demo.service;

import com.lucio.springboot.demo.dao.EmployeeJpaRepository;
import com.lucio.springboot.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    @Override
    public List<Employee> getEmployees() {
        return employeeJpaRepository.findAll();
    }

    @Override
    public Employee getEmployee(int id) {
        Optional<Employee> employeeOptional = employeeJpaRepository.findById(id);
        return employeeOptional.orElse(null);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeJpaRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        Optional<Employee> employeeOptional = employeeJpaRepository.findById(id);
        employeeOptional.ifPresent(employee -> employeeJpaRepository.delete(employee));
    }

    @Override
    public Employee modifyEmployee(Employee employee) {
        return employeeJpaRepository.save(employee);
    }
}
