package com.buseni.churchlog.task;

import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {

        this.taskService = taskService;
    }

    @GetMapping(value = "")
    public List<TaskDto> getTasks(@RequestParam( required = false) String type){
       return this.taskService.getTasks(type);

    }

    @GetMapping(value = "/{id}")
    public TaskDto getTaskById(@PathVariable(value = "id") Integer id){
        return  this.taskService.getTaskById(id);

    }

    @DeleteMapping(value = "/{id}")
    public void deleteTaskById(@PathVariable(value = "id") Integer id){
         this.taskService.deleteTaskById(id);
    }

    @PostMapping(value = "")
    public ResponseEntity<Integer> createTask(@RequestBody @Validated TaskDto taskDto){
       Integer idCreated =  this.taskService.createTask(taskDto);
        return ResponseEntity.ok(idCreated);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updateTask( @PathVariable(value = "id") Integer id, @RequestBody @Validated TaskDto taskDto){
        this.taskService.updateTask(taskDto);
        return ResponseEntity.noContent().build();
    }

}
