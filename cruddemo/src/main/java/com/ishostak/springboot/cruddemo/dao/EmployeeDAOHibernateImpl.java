package com.ishostak.springboot.cruddemo.dao;

import com.ishostak.springboot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class EmployeeDAOHibernateImpl implements EmployeeDAO{

    //define EntityManager
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {

        //ger current session
        Session currentSession = entityManager.unwrap(Session.class);

        //create a query
        Query<Employee> theQuery =
                currentSession.createQuery("from Employee ", Employee.class);

        //execute query and get user list
        List<Employee> resultList = theQuery.getResultList();

        //return  result
        return resultList;
    }

    @Override
    public Employee findById(int id) {
        //ger current session
        Session currentSession = entityManager.unwrap(Session.class);

        //get user
        Employee employee = currentSession.get(Employee.class, id);

        //return  result
        return employee;
    }

    @Override
    public void Save(Employee employee) {
        //ger current session
        Session currentSession = entityManager.unwrap(Session.class);

        //save user
        currentSession.saveOrUpdate(employee);
    }

    @Override
    public void deleteById(int id) {
        //ger current session
        Session currentSession = entityManager.unwrap(Session.class);

        //delete user
        Query theQuery =
                currentSession.createQuery(
                        "delete from Employee where id =:empID");

        theQuery.setParameter("empID", id);

        theQuery.executeUpdate();
    }
}
