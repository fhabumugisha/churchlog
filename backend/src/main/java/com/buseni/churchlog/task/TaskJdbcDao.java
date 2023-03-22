package com.buseni.churchlog.task;

import com.buseni.churchlog.task.entities.Task;

import java.time.LocalDate;
import java.util.List;

public interface TaskJdbcDao {
    List<Task> getTaskByTypePerMonth(String task, LocalDate date);
}
