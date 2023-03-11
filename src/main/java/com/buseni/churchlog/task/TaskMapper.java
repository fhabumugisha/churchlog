package com.buseni.churchlog.task;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Duration;
import java.util.List;
import java.util.Set;

@Mapper
public interface TaskMapper {


    Task dtoToEntity(TaskDto taskDto);


    TaskDto entityToDto(Task task);

    Set<TaskDto> map(Set<Task> tasks);

    List<TaskDto> map(List<Task> tasks);

    default Long map(Duration duration) {
        return duration == null ? null : duration.toMinutes();
    }
    default Duration map(Long duration) {
        return duration == null ? null : Duration.ofMinutes(duration);
    }
}
