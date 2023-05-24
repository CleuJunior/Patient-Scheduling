package com.junior.br.schedule.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @Column(name = "date_hour")
    private LocalDateTime time;

    @Column(name = "date_creation")
    private LocalDateTime dateCreation;

    @ManyToOne
    private Patient patient;
}
