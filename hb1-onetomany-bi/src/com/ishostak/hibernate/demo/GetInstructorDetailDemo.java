package com.ishostak.hibernate.demo;

import com.ishostak.hibernate.demo.Entity.Instructor;
import com.ishostak.hibernate.demo.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {
    public static void main(String[] args) {

        SessionFactory factory =  new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int theId = 1;

            InstructorDetail detail = session.get(InstructorDetail.class, theId);

            System.out.println(detail);

            Instructor instructor = detail.getInstructor();

            System.out.println(instructor);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
