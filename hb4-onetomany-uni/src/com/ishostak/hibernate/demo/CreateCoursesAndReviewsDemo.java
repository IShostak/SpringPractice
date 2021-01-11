package com.ishostak.hibernate.demo;

import com.ishostak.hibernate.demo.Entity.Course;
import com.ishostak.hibernate.demo.Entity.Instructor;
import com.ishostak.hibernate.demo.Entity.InstructorDetail;
import com.ishostak.hibernate.demo.Entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndReviewsDemo {
    public static void main(String[] args) {

        SessionFactory factory =  new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            //start transaction
            session.beginTransaction();

            //create a course
            Course tmpCourse = new Course("Pac Man - how to score one million points");

            //add some reviews
            tmpCourse.add(new Review("Awesome"));
            tmpCourse.add(new Review("Great course, loved it"));

            //save course and reviews
            session.save(tmpCourse);

            //commit transaction
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
