package com.buseni.churchlog.task;

import com.buseni.churchlog.task.entities.Task;
import com.buseni.churchlog.task.mappers.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDate;
import java.util.*;

@Service
public class TaskServiceImpl implements  TaskService{

    private  TaskRepo taskRepo;

    private TaskMapper mapper;

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
    public List<TaskDto> getTasksByTypeAndDate(String type, LocalDate date) {
        return mapper.map(taskRepo.getTaskByTypePerMonth(type, date));
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

    @Transactional
    @Override
    public Integer createTask(TaskDto taskDto) {
        Task newTask =  mapper.dtoToEntity(taskDto);
        Task taskCreated = taskRepo.save(newTask);
        return taskCreated.getId();
    }
}
