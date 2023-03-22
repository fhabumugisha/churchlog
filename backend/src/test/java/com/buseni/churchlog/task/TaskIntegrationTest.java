package com.buseni.churchlog.task;

import com.buseni.churchlog.AbstractTestcontainers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TaskIntegrationTest extends AbstractTestcontainers {

    @Autowired
    private WebTestClient webTestClientClient;

    @Test
    void canAddTask(){

        TaskDto dto = TaskDto.builder()
                .taskDate(LocalDate.now())
                .type("Réunion")
                .description("Test")
                .userName("Fab").build();

        webTestClientClient.post()
                .uri("/api/v1/tasks")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(dto), TaskDto.class)
                .exchange()
                .expectStatus()
                .isOk();


       List<TaskDto> tasks = webTestClientClient.get()
                .uri("/api/v1/tasks")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(new ParameterizedTypeReference<TaskDto>() {
                }).returnResult().getResponseBody();

        TaskDto expected = TaskDto.builder()
                .taskDate(LocalDate.now())
                .type("Réunion")
                .description("Test")
                .userName("Fab").build();
       Assertions.assertThat(tasks).usingRecursiveFieldByFieldElementComparatorIgnoringFields("id").contains(expected);

       var id = tasks.stream().filter(t-> t.getDescription().equals(dto.getDescription())).map(TaskDto::getId).findFirst().orElseThrow();
       expected.setId(id);

         webTestClientClient.get()
                .uri("/api/v1/tasks" +"/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(new ParameterizedTypeReference<TaskDto>() {
                }).isEqualTo(expected);
    }
}