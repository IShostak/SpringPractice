package com.ishostak.hibernate.demo;

import com.ishostak.hibernate.demo.Entity.Course;
import com.ishostak.hibernate.demo.Entity.Instructor;
import com.ishostak.hibernate.demo.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateIInstructorDemo {
    public static void main(String[] args) {

        SessionFactory factory =  new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Instructor tmpInstructor = new Instructor("Jhon", "Doe", "Doe@mail.ru");

            InstructorDetail detail = new InstructorDetail( "youtube/Doe", "Gaming");

            tmpInstructor.setInstructorDetail(detail);

            session.beginTransaction();

            session.save(tmpInstructor);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
