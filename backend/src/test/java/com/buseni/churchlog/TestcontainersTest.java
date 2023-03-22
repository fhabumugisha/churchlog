package com.buseni.churchlog;

import org.assertj.core.api.Assertions;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;


public class TestcontainersTest extends AbstractTestcontainers{



    @Test
    void canStartPostgreDB() {
        Assertions.assertThat(postgreSQLContainer.isRunning()).isTrue();
    }

}
