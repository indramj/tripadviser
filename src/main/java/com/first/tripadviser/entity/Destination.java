package com.first.tripadviser.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "tb_destination")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long destId;
    private String contentId;
    private String destTitle;
    private String mapX;
    private String mapY;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Duration stayTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planNo")
    private Plan plan;
}
