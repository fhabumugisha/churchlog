package com.buseni.churchlog;

import com.buseni.churchlog.task.Task;
import com.buseni.churchlog.task.TaskRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.Date;

@Slf4j
@Component
public class DbInitializer implements CommandLineRunner {


	private final TaskRepo taskRepo;
	
	public DbInitializer(TaskRepo taskRepo) {
		this.taskRepo = taskRepo;
	}
	
	@Override
	public void run(String... args) throws Exception {
	/*	this.taskRepo.deleteAll();
		taskRepo.save(Task.builder().taskDate(new Date()).type("Réunion").service("Bureau").description("Préparation réunion 11.03").duration(Duration.ofHours(2)).userName("Fab").build());
		taskRepo.save(Task.builder().taskDate(new Date()).type("Envoie mail").persons("Pascal").description("Propositiion 24.03").userName("Fab").build());
		taskRepo.findAll().forEach(t -> {
			log.info("{} Task : {} ", "[TASKLOG]", t);
		});

	 */
	}

}
