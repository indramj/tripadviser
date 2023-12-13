package com.first.tripadviser.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "tb_plan")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planNo;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(mappedBy = "plan" , cascade = CascadeType.ALL ,orphanRemoval = true)
    private List<Destination> destList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

    public void changeStartDate(LocalDate startDate){
        this.startDate = startDate;
    }
    public void changeEndDate(LocalDate endDate){
        this.endDate = endDate;
    }
}
