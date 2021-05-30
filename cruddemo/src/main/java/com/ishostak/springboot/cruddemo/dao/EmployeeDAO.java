package com.ishostak.springboot.cruddemo.dao;

import com.ishostak.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();

    public Employee findById(int id);

    public void Save(Employee employee);

    public void deleteById(int id);
}
