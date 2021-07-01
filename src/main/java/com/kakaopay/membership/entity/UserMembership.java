package com.kakaopay.membership.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "USER_MEMBERSHIP")
@NoArgsConstructor
public class UserMembership {

    @Id
    @Column(name = "user_membership_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "membership_id")
    Membership membership;

    @Column(name = "user_membership_membershipStatus")
    private Boolean membershipStatus;

    @Column(name = "user_membership_point")
    private Long point;

    @CreatedDate
    private LocalDateTime startDate;

}
