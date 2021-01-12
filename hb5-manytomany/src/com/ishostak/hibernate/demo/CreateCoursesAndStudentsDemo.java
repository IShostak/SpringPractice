package com.ishostak.hibernate.demo;

import com.ishostak.hibernate.demo.Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndStudentsDemo {
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

            //create a course
            Course tmpCourse = new Course("Pac Man - how to score one million points");

            //save course
            session.save(tmpCourse);
            System.out.println("Course saved " + tmpCourse);

            //create students
            Student tmpStudent1 = new Student("Jhon", "Doe", "jhon@mail.com");
            Student tmpStudent2 = new Student("Mary>", "Fery", "mary@mail.com");

            //add students to the course
            tmpCourse.addStudent(tmpStudent1);
            tmpCourse.addStudent(tmpStudent2);

            //saving students
            System.out.println("Saving students: ");
            session.save(tmpStudent1);
            session.save(tmpStudent2);
            System.out.println("Students saved: " + tmpCourse.getStudents());

            //commit transaction
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
