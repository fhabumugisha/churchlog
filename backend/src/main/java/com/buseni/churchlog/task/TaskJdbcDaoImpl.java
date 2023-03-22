package com.buseni.churchlog.task;

import com.buseni.churchlog.task.entities.Task;
import com.buseni.churchlog.task.mappers.TaskRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class TaskJdbcDaoImpl implements  TaskJdbcDao{

   private final NamedParameterJdbcTemplate jdbcTemplate;
   private final TaskRowMapper taskRowMapper;

  public  TaskJdbcDaoImpl(NamedParameterJdbcTemplate jdbcTemplate, TaskRowMapper taskRowMapper){
        this.jdbcTemplate = jdbcTemplate;
      this.taskRowMapper = taskRowMapper;
  }

    @Override
    public List<Task> getTaskByTypePerMonth(String type, LocalDate date) {
      log.info("{} getTaskByTypePerMonth", "[LOGOPS]");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("type", type);
        parameters.put("year", date.getYear());
        parameters.put("month", date.getMonthValue() );
      String sql = """
        select * from task where type =:type and  date_part('year', task_date) =:year and date_part('month', task_date) = :month;
        """;
      //jdbcTemplate.query(sql, (rs, rowNum) -> {});

        return jdbcTemplate.query(sql, parameters, taskRowMapper);


    }
}
