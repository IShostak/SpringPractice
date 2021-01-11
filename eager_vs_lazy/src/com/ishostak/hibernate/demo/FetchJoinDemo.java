package com.ishostak.hibernate.demo;

import com.ishostak.hibernate.demo.Entity.Course;
import com.ishostak.hibernate.demo.Entity.Instructor;
import com.ishostak.hibernate.demo.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {
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

            Query<Instructor> query =
                    session.createQuery("select i from Instructor i "
                                + "JOIN FETCH i.courses "
                                + "where i.id =:theInstructorId",
                            Instructor.class);

            query.setParameter("theInstructorId", 1);

            Instructor instructor = query.getSingleResult();

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
