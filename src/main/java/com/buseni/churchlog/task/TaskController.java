package com.buseni.churchlog.task;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "")
    public List<TaskDto> getTasks(){
        return  this.taskService.getTasks();

    }

    @GetMapping(value = "/{id}")
    public TaskDto getTaskById(@PathVariable(value = "id") UUID id){
        return  this.taskService.getTaskById(id);

    }
}
