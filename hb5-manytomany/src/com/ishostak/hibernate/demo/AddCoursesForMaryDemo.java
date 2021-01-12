package com.ishostak.hibernate.demo;

import com.ishostak.hibernate.demo.Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForMaryDemo {
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

            //create more courses
            Course tmp1 = new Course("Boxing for beginners");
            Course tmp2 = new Course("Video editing for PROs");
            Course tmp3 = new Course("Gaming as an ART");

            //add Mary to courses
            tmp1.addStudent(tmpStudent1);
            tmp2.addStudent(tmpStudent1);
            tmp3.addStudent(tmpStudent1);

            //saving courses
            System.out.println("Saving courses: ");
            session.save(tmp1);
            session.save(tmp2);
            session.save(tmp3);

            //commit transaction
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
