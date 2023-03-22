package com.buseni.churchlog.task;

import com.buseni.churchlog.task.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Integer>, TaskJdbcDao {
    List<Task> findByType(String type);

    List<Task> findByService(String service);

    List<Task> findByUserName(String username);
}
