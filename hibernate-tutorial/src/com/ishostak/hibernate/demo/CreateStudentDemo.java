package com.ishostak.hibernate.demo;

import com.ishostak.hibernate.demo.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory =  new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student tmpStudent =
                    new Student("Paul", "Will", "paul@mail.com");

            session.beginTransaction();

            session.save(tmpStudent);

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
