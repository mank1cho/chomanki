package com.kakaopay.membership.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Getter
@Entity
@Table(name = "user_membership")
@NoArgsConstructor
public class UserMembership extends BaseDateTime{

    @Id
    @Column(name = "user_membership_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_seq")
    User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "membership_seq")
    Membership membership;

    @Column(name = "user_membership_membershipStatus")
    private String membershipStatus;

    @Column(name = "user_membership_point")
    private Long point;

    @Builder
    public UserMembership(Long id, User user, Membership membership, String membershipStatus, Long point){
        this.id = id;
        this.user = user;
        this.membership = membership;
        this.membershipStatus = membershipStatus;
        this.point = point;
    }
}
