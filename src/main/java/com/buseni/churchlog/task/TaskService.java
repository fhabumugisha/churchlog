package com.buseni.churchlog.task;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    /**
     * Get all tasks
     * @return
     */
    List<TaskDto> getTasks();

    TaskDto getTaskById(UUID id) ;
}
