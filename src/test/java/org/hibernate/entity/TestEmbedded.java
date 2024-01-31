package org.hibernate.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class TestEmbedded {

    String description;

    public TestEmbedded() {
        // empty constructor
    }

    public TestEmbedded(final String description) {
        this.description = description;
    }
}
