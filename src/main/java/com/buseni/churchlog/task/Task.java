package com.buseni.churchlog.task;

import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
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
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "task_id_sequence")
    @SequenceGenerator(name = "task_id_sequence", sequenceName = "task_id_sequence")
    private Integer id;

    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String type;

    private String service;

    private String persons;

    private Duration duration;

    @Column(nullable = false)
    private Date taskDate;

    private String userName;



}
