package com.ishostak.hibernate.demo;

import com.ishostak.hibernate.demo.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory =  new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //start transaction
            session.beginTransaction();

            /**
             * all students
             */
            List<Student> students =
                    session.createQuery("from Student").getResultList();

            System.out.println("list of students: ");
            printStudents(students);

            /**
             * students with last name Doe
             */
            students = session.createQuery("from Student s where" +
                    " s.lastName= 'Doe'").getResultList();
            System.out.println("\n\nStudents with last name Doe: ");

            printStudents(students);

            /**
             * students with last name Doe or name Daffy
             */
            students =
                    session.createQuery("from Student s where" +
                    " s.lastName= 'Doe'" +
                    " or s.firstName = 'Daffy'").getResultList();

            System.out.println("\n\nStudents with last name Doe or name Daffy: ");

            printStudents(students);

            /**
             * students with mail like mail.com
             */
            students =
                    session.createQuery("from Student s where" +
                            " s.email like '%mail.com'").getResultList();

            System.out.println("\n\nStudents with emails: MAIL.com ");

            printStudents(students);

            //commit transaction
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }

    private static void printStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
