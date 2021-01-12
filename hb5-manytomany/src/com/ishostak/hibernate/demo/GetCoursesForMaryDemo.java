package com.ishostak.hibernate.demo;

import com.ishostak.hibernate.demo.Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesForMaryDemo {
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

            //get student from DB
            Student tmpStudent1 = session.get(Student.class, 2);
            System.out.println("Student loaded : " + tmpStudent1);
            System.out.println("Users courses: " + tmpStudent1.getCourseList());

            //commit transaction
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
