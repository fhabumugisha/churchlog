package com.buseni.churchlog.task;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements  TaskService{;

   private static List<TaskDto> tasks =  new ArrayList<TaskDto>();

   static {
       tasks.add(TaskDto.builder().id(UUID.randomUUID()).taskDate(new Date()).type("Réunion").service("Bureau").description("Préparation réunion 11.03").duration(Duration.ofHours(2)).userName("Fab").build());
       tasks.add(TaskDto.builder().id(UUID.randomUUID()).taskDate(new Date()).type("Envoie mail").persons("Pascal").description("Propositiion 24.03").userName("Fab").build());
   }

    @Override
    public List<TaskDto> getTasks() {
        return tasks;
    }

    @Override
    public TaskDto getTaskById(UUID id)  {
        return tasks.stream().filter(taskDto -> taskDto.getId().equals(id)).findFirst().orElseThrow();
    }
}
