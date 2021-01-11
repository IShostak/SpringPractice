package com.ishostak.hibernate.demo;

import com.ishostak.hibernate.demo.Entity.Course;
import com.ishostak.hibernate.demo.Entity.Instructor;
import com.ishostak.hibernate.demo.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {
    public static void main(String[] args) {

        SessionFactory factory =  new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Instructor tmp = session.get(Instructor.class, 1);

            Course guitarCourse = new Course("Guitar gide");
            Course pianoCourse = new Course("Piano pro");

            tmp.add(guitarCourse);
            tmp.add(pianoCourse);

            session.save(guitarCourse);
            session.save(pianoCourse);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
