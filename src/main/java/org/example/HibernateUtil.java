package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(HibernateUtil.class.getName());

    // Initialization of SessionFactory
    // Static block is run only once when class is being loaded into memory, it's tied to class rather than instance
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            logger.info("SessionFactory initialized successfully.");
        } catch (Exception e) {
            logger.error("Error initializing SessionFactory: {}", e.getMessage(), e);
            throw new ExceptionInInitializerError("SessionFactory initialization failed. See logs for details.");
        }
    }

    // Method to retrieve the SessionFactory
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            logger.error("SessionFactory was not initialized.");
            throw new IllegalStateException("SessionFactory is not available. Initialization failed.");
        }
        return sessionFactory;
    }

    // Method to close the SessionFactory
    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
            logger.info("SessionFactory closed successfully.");
        }
    }
}
