package com.buseni.churchlog.task.mappers;


import com.buseni.churchlog.task.entities.Task;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Component
public class TaskRowMapper implements RowMapper<Task> {
        @Override
        public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
            Task task = new Task();
            Date tastDate = rs.getDate("TASK_DATE");
            task.setId(rs.getInt("ID"));
            task.setType(rs.getString("TYPE"));
            task.setTaskDate( tastDate !=null ? tastDate.toLocalDate() : null);
            task.setDescription(rs.getString("DESCRIPTION"));
            task.setService(rs.getString("SERVICE"));
            task.setPersons(rs.getString("PERSONS"));
            task.setUserName(rs.getString("USER_NAME"));
            task.setDuration(Duration.of(rs.getLong("DURATION"), ChronoUnit.MINUTES ));

            return task;
        }
    }

