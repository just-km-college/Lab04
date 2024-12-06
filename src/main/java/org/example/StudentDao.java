package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.SelectionQuery;

import java.util.List;

public class StudentDao {

    public static void save(Student student) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(student);
        transaction.commit();
        session.close();

    }

    public static void update(Student student, int id) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student studentTemp = session.get(Student.class,id);
        studentTemp.setName(student.getName());
        studentTemp.setHeight(student.getHeight());

        session.merge(studentTemp);

        transaction.commit();
        session.close();

    }

    public static void getAllStudents() {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        SelectionQuery<Student> query = session.createSelectionQuery("FROM Student", Student.class);

        List<Student> studentList = query.list();

        for (Student student : studentList) {
            System.out.println(student);
        }

        session.close();

    }

    public static Student getById(int id) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Student student = session.get(Student.class,id);
        session.close();
        return student;

    }

    public static void deleteById(int id) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class,id);
        if (student != null) {
            session.remove(student);
            transaction.commit();
        } else {
            System.out.println("This student cannot be found in data base");
        }

        session.close();

    }

}
