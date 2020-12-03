package com.ishostak.hibernate.demo;

import com.ishostak.hibernate.demo.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeTestDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate2.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        Employee newEmp =  getById(1,factory);

//        deleteById(1, factory);
//        deleteById(2, factory);

        System.out.println(newEmp);
    }

    public static void saveEmployee(Employee employee, SessionFactory factory) {

        Session session = factory.getCurrentSession();

        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
    }

    public static Employee getById(int id, SessionFactory factory) {
        Session session = factory.getCurrentSession();
        Employee tmp;

        session.beginTransaction();
        tmp = session.get(Employee.class, id);
        session.getTransaction().commit();

        return tmp;
    }

    public static void deleteById(int id, SessionFactory factory) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        session.createQuery("delete Employee where id = '" + id +"'" )
                .executeUpdate();

        session.getTransaction().commit();
    }
}
