package com.first.tripadviser.entity;

import lombok.*;
import org.springframework.data.geo.Point;

import javax.persistence.*;

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
    private Long destinationId;
    private String name;
    private String cityName;
    private String desc;
    private Point position;

}
