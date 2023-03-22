package com.buseni.churchlog.task;

import com.buseni.churchlog.AbstractTestcontainers;
import com.buseni.churchlog.task.entities.Task;
import com.buseni.churchlog.task.mappers.TaskRowMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

class TaskJdbcDaoImplTest extends AbstractTestcontainers {

    private  TaskJdbcDaoImpl taskJdbcDao;

    private final TaskRowMapper taskRowMapper =  new TaskRowMapper();
    @BeforeEach
    void setUp() {
        taskJdbcDao = new TaskJdbcDaoImpl(getJdbcTemplate(), taskRowMapper);
    }

    @Test
    void getTaskByTypePerMonth() {
        //Given
        String type = "Réunion";
        LocalDate date  =   LocalDate.now();

      List<Task> tasks = taskJdbcDao.getTaskByTypePerMonth(type,date);
      Assertions.assertThat(tasks.size()).isEqualTo(0);
    }
}