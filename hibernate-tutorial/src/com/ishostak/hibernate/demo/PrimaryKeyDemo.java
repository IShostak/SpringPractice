package com.ishostak.hibernate.demo;

import com.ishostak.hibernate.demo.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

        SessionFactory factory =  new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student tmpStudent1 =
                    new Student("Mary", "piblic", "Mary@mail.com");

            Student tmpStudent2 =
                    new Student("John", "Doe", "John@mail.com");
            Student tmpStudent3 =
                    new Student("Bonita", "AppleBum", "Bonita@mail.com");

            session.beginTransaction();

            session.save(tmpStudent1);
            session.save(tmpStudent2);
            session.save(tmpStudent3);

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
