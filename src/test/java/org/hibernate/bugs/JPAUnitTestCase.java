package org.hibernate.bugs;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.persistence.Persistence;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

    // Entities are auto-discovered, so just add them anywhere on class-path
    // Add your tests, using standard JUnit.
    @Test
    public void hhh17694Test() {
        Assertions.assertDoesNotThrow(
                () -> Persistence.createEntityManagerFactory("templatePU")
        );
    }
}
