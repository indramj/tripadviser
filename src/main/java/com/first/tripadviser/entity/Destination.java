package com.first.tripadviser.entity;

import lombok.*;
import org.springframework.data.geo.Point;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "tb_destination")
public class Destination {
    @Id
    private String memberId;
    private String contentId;
    private String name;
    private String cityName;
    private Point position;
    private LocalDateTime date;

}
