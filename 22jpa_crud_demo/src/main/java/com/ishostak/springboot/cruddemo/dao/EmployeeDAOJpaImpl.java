package com.ishostak.springboot.cruddemo.dao;

import com.ishostak.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Query query = entityManager.createQuery("from Employee ");

        List<Employee> result = query.getResultList();

        return result;
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void Save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);

        employee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int id) {
        Query query = entityManager.createQuery(
                "delete from Employee where id=:id");

        query.setParameter("id", id);
        query.executeUpdate();
    }
}
