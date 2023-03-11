package com.buseni.churchlog.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.*;
import java.util.random.RandomGenerator;

@Service
public class TaskServiceImpl implements  TaskService{;

    private  TaskRepo taskRepo;

    private  TaskMapper mapper;

    @Autowired
    public TaskServiceImpl(TaskRepo taskRepo, TaskMapper mapper){
        this.taskRepo = taskRepo;
        this.mapper = mapper;
    }

    @Override
    public List<TaskDto> getTasks(String type)
    {
        if (null != type) {
            return getTaskByType(type);
        }
        return mapper.map(taskRepo.findAll());
    }

    @Override
    public TaskDto getTaskById(Integer id)  {
        Task task = taskRepo.findById(id).orElseThrow(() -> new TaskNotFoundException("Task with id  [%s] not found".formatted(id)));
        return mapper.entityToDto(task);
    }

    @Override
    public List<TaskDto> getTaskByType(String type) {
        return mapper.map(taskRepo.findByType(type));
    }

    @Override
    public List<TaskDto> getTaskByService(String service) {
        return mapper.map(taskRepo.findByService(service));
    }

    @Override
    public List<TaskDto> getTaskByUsername(String username) {
        return mapper.map(taskRepo.findByUserName(username));
    }

    @Override
    public void deleteTaskById(Integer id) {
           taskRepo.deleteById(id);
    }

    @Override
    public TaskDto updateTask(TaskDto task) {
       if(null != task && taskRepo.existsById(task.getId())){
            Task toUpdate = taskRepo.findById(task.getId()).get();
            toUpdate.setDescription(task.getDescription());
            toUpdate.setService(task.getService());
            toUpdate.setTaskDate(task.getTaskDate());
            toUpdate.setDuration(Duration.ofMinutes(task.getDuration()));
            toUpdate.setPersons(task.getPersons());
            taskRepo.save(toUpdate);
            task = mapper.entityToDto(toUpdate);
       }
        return task;
    }

    @Override
    public Integer createTask(TaskDto task) {
        Task taskCreated = taskRepo.save(mapper.dtoToEntity(task));
        return taskCreated.getId();
    }
}
