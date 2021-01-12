package com.ishostak.hibernate.demo;

import com.ishostak.hibernate.demo.Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeletePacmanCourseDemo {
    public static void main(String[] args) {

        SessionFactory factory =  new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            //start transaction
            session.beginTransaction();

            //get pacman course from DB
            Course course = session.get(Course.class, 10);

            //delete the course
            session.delete(course);

            //commit transaction
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
