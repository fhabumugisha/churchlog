package com.buseni.churchlog.task.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Task {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "task_id_seq")
    @SequenceGenerator(name = "task_id_seq", sequenceName = "task_id_seq", allocationSize = 1)
    private Integer id;

    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String type;

    private String service;

    private String persons;

    private Duration duration;

    @Column(nullable = false, name = "task_date")
    @Temporal(TemporalType.DATE)
    private LocalDate taskDate;

    @Column(nullable = false, name = "user_name")
    private String userName;



}
