package com.buseni.churchlog.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDto {

    private UUID id;
    private String title;

    private String description;

    private String type;

    private String service;

    private String persons;

    private Duration duration;

    private Date taskDate;

    private String userName;
}
