package com.ishostak.springboot.cruddemo.service;

import com.ishostak.springboot.cruddemo.dao.EmployeeDAO;
import com.ishostak.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO dao;

    @Autowired
    public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int id) {
        return dao.findById(id);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        dao.Save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        dao.deleteById(id);
    }
}
