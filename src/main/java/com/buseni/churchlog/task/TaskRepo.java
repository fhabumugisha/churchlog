package com.buseni.churchlog.task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Integer> {
    List<Task> findByType(String type);

    List<Task> findByService(String service);

    List<Task> findByUserName(String username);
}
