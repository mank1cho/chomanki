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
@Table(name = "user_membership", uniqueConstraints = {
        @UniqueConstraint(name = "user_membershipId_unique", columnNames = {"user_no", "membership_id"})
})
@NoArgsConstructor
public class UserMembership extends BaseDateTime{

    @Id
    @Column(name = "user_membership_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userMembershipNo;

    @Column(name = "membership_id")
    String membershipId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no")
    User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "membership_no")
    Membership membership;

    @Column(name = "user_membership_membershipStatus")
    private String membershipStatus;

    @Column(name = "user_membership_point")
    private int point;

    public boolean deactivateMembership(){
        this.membershipStatus = "N";
        return true;
    }

    public boolean accumulatePoint(int amount){
        this.point+=getPoint(amount);
        return true;
    }

    public int getPoint(int amount){
        return amount/100;
    }

    @Builder
    public UserMembership(Long userMembershipNo, String membershipId, User user, Membership membership, String membershipStatus, int point){
        this.userMembershipNo = userMembershipNo;
        this.membershipId = membershipId;
        this.user = user;
        this.membership = membership;
        this.membershipStatus = membershipStatus;
        this.point = point;
    }
}
