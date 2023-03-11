package com.buseni.churchlog;

import com.buseni.churchlog.task.Task;
import com.buseni.churchlog.task.TaskDto;
import com.buseni.churchlog.task.TaskRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@Slf4j
public class ChurchlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChurchlogApplication.class, args);
	}


		CommandLineRunner runner (TaskRepo taskRepo){
		return args -> {
			log.debug("{} Insert tasks : ", "[TASKLOG]");
			taskRepo.save(Task.builder().taskDate(new Date()).type("Réunion").service("Bureau").description("Préparation réunion 11.03").duration(Duration.ofHours(2)).userName("Fab").build());
			taskRepo.save(Task.builder().taskDate(new Date()).type("Envoie mail").persons("Pascal").description("Propositiion 24.03").userName("Fab").build());
				taskRepo.findAll().forEach(t -> {
					log.info("{} Task : ", "[TASKLOG]", t.toString());
				});
		};
		}
}
