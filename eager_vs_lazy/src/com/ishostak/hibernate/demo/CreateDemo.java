package com.ishostak.hibernate.demo;

import com.ishostak.hibernate.demo.Entity.Instructor;
import com.ishostak.hibernate.demo.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {

        SessionFactory factory =  new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Instructor tmpInstructor = new Instructor("asdfd", "sdagh", "asdf@mail.ru");

            InstructorDetail detail = new InstructorDetail( "asdf/paul", "reading");

            tmpInstructor.setInstructorDetail(detail);

            session.beginTransaction();

            session.save(tmpInstructor);

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
