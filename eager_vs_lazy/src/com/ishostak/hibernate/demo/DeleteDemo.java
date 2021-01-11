package com.ishostak.hibernate.demo;

import com.ishostak.hibernate.demo.Entity.Instructor;
import com.ishostak.hibernate.demo.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {

        SessionFactory factory =  new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Instructor tmpInstructor = session.get(Instructor.class, 2);

            System.out.println("Found one: " + tmpInstructor);

            if (tmpInstructor != null) {
                session.delete(tmpInstructor);
            }

            session.getTransaction().commit();

            System.out.println("Deleted");
        } finally {
            factory.close();
        }
    }
}
