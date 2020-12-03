package com.ishostak.hibernate.demo;

import com.ishostak.hibernate.demo.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RetrieveStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory =  new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student tmpStudent =
                    new Student("Daffy", "Duck", "Daffy@mail.com");

            session.beginTransaction();

            System.out.println("Saving: " + tmpStudent);
            session.save(tmpStudent);

            session.getTransaction().commit();

            //find out the students id:
            System.out.println("ID: " + tmpStudent.getId());

            //get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //retrieve student
            System.out.println("Getting student with id: " + tmpStudent.getId());

            Student myStud = session.get(Student.class, tmpStudent.getId());

            System.out.println("Student from db: " + myStud);
            //commit the transaction
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
