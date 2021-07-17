package com.ishostak.thymeleafdemo.service;

import com.ishostak.thymeleafdemo.Entity.Employee;
import com.ishostak.thymeleafdemo.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return repository.findAllByOrderByLastNameAsc();
    }

    @Override
    @Transactional
    public Employee findById(int id) {
        Optional<Employee> result = repository.findById(id);

        if(!result.isPresent()) {
            throw new RuntimeException("No employee with id: " + id);
        }

        return result.get();
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        repository.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
