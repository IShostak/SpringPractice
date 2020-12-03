package com.ishostak.hibernate.demo;

import com.ishostak.hibernate.demo.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory =  new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            int stId = 1;

            Student myStud = session.get(Student.class, stId);

            System.out.println(myStud);

            myStud.setFirstName("123213");

            //commit the transaction
            session.getTransaction().commit();


            session = factory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("Update Student set email='foo@gmail.com'" )
            .executeUpdate();

            //commit the transaction
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
