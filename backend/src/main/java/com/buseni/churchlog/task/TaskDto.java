package com.buseni.churchlog.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.convert.DurationUnit;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDto {

    private Integer id;
    private String title;

    private String description;

    private String type;

    private String service;

    private String persons;

    @DurationUnit(value = ChronoUnit.MINUTES)
    private Long duration;

    private LocalDate taskDate;

    private String userName;
}
