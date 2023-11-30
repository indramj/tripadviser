package com.first.tripadviser.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "tb_review")
public class Review extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewNum;
    private Long contentId;
    private String review;
    private String password;
    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "memberId")
    private Member member;


    public void changeReview(String review){
        this.review = review;
    }

}
