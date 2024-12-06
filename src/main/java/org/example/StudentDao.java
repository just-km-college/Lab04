package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.SelectionQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class StudentDao {

    private static final Logger logger = LoggerFactory.getLogger(StudentDao.class);
    private static SessionFactory sessionFactory;

    public StudentDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void save(Student student) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.persist(student);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                logger.error("Failed to save student: {}", student, e);
            }
        } catch (Exception e) {
            logger.error("Failed to open session for saving student: {}", student, e);
        }
    }

    public void update(Student student, int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                Student studentTemp = session.get(Student.class, id);
                if (studentTemp != null) {
                    studentTemp.setName(student.getName());
                    studentTemp.setHeight(student.getHeight());
                    session.merge(studentTemp);
                    transaction.commit();
                } else {
                    logger.warn("Student with ID {} not found for update", id);
                }
            } catch (Exception e) {
                transaction.rollback();
                logger.error("Failed to update student with ID: {}", id, e);
            }
        } catch (Exception e) {
            logger.error("Failed to open session for updating student with ID: {}", id, e);
        }
    }

    public List<Student> getAllStudents() {
        try (Session session = sessionFactory.openSession()) {
            SelectionQuery<Student> query = session.createSelectionQuery("FROM Student", Student.class);
            return query.list();
        } catch (Exception e) {
            logger.error("Failed to fetch all students", e);
            return List.of(); // Return an empty list on failure
        }
    }

    public Student getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Student.class, id);
        } catch (Exception e) {
            logger.error("Failed to fetch student with ID: {}", id, e);
            return null; // Return null to indicate failure
        }
    }

    public void deleteById(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                Student student = session.get(Student.class, id);
                if (student != null) {
                    session.remove(student);
                    transaction.commit();
                    logger.info("Student with ID {} successfully deleted", id);
                } else {
                    logger.warn("Student with ID {} not found for deletion", id);
                }
            } catch (Exception e) {
                transaction.rollback();
                logger.error("Failed to delete student with ID: {}", id, e);
            }
        } catch (Exception e) {
            logger.error("Failed to open session for deleting student with ID: {}", id, e);
        }
    }

}
