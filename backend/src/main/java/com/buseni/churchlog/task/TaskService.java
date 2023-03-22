package com.buseni.churchlog.task;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface TaskService {

    /**
     * Get all tasks
     * @return
     */
    List<TaskDto> getTasks(String type);

    /**
     * Read task by id
     * @param id
     * @return task
     */
    TaskDto getTaskById(Integer id) ;

    /**
     * Read task by id
     * @param type the type of the task
     * @param  date the date of the task
     * @return task
     */
    List<TaskDto> getTasksByTypeAndDate(String type, LocalDate date ) ;

    /**
     * Read task by type
     * @param type
     * @return  list of given type
     */
    List<TaskDto> getTaskByType(String type) ;

    /**
     * Read task by service
     * @param service
     * @return list of given service
     */
    List<TaskDto> getTaskByService(String service) ;

    /**
     * Read task by username
     * @param username
     * @return list of given username
     */
    List<TaskDto> getTaskByUsername(String username) ;

    /**
     * Delete task by id
     * @param id
     * @return
     */
    void deleteTaskById(Integer id) ;

    /**
     * Updates the given task
     * @param task
     * @return
     */
    TaskDto  updateTask(TaskDto task);


    /**
     * Create the given task
     * @param task
     * @return id of the created task
     */
    Integer  createTask(TaskDto task);
}
