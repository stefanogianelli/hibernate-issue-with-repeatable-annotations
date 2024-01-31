package org.hibernate.entity;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class TestEntity {

    public static class TestEmbeddedConverter implements AttributeConverter<Set<TestEmbedded>, String> {

        @Override
        public String convertToDatabaseColumn(final Set<TestEmbedded> attribute) {
            if (attribute != null && !attribute.isEmpty()) {
                return attribute.stream().map(t -> t.description).collect(Collectors.joining(","));
            }
            return null;
        }

        @Override
        public Set<TestEmbedded> convertToEntityAttribute(final String dbData) {
            if (dbData != null) {
                return Arrays.stream(dbData.split(",")).map(TestEmbedded::new).collect(Collectors.toSet());
            }
            return null;
        }
    }

    @Id
    @GeneratedValue
    Long id;

    @Convert(converter = TestEmbeddedConverter.class)
    Set<TestEmbedded> embedded;

    public TestEntity() {
        // empty constructor
    }

    public TestEntity(final TestEmbedded embedded) {
        this.embedded = Set.of(embedded);
    }
}
