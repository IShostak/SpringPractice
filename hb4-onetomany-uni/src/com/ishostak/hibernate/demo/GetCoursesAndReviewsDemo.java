package com.ishostak.hibernate.demo;

import com.ishostak.hibernate.demo.Entity.Course;
import com.ishostak.hibernate.demo.Entity.Instructor;
import com.ishostak.hibernate.demo.Entity.InstructorDetail;
import com.ishostak.hibernate.demo.Entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesAndReviewsDemo {
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
 
            //Get a course
            Course tmpCourse = session.get(Course.class, 10);

            //get all reviews
            System.out.println(tmpCourse.getReviewList());

            //commit transaction
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
