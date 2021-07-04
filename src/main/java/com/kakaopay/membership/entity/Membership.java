package com.kakaopay.membership.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Entity
@Table(name = "membership")
@NoArgsConstructor
public class Membership {

    @Id
    @Column(name = "membership_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long membershipNo;

    @Column(name = "membership_name", unique = true)
    private String membershipName;

    @OneToMany(mappedBy = "membership", cascade = CascadeType.PERSIST)
    private List<UserMembership> userMembershipList = new ArrayList<>();

    @Builder
    Membership(Long membershipNo, String membershipName, List<UserMembership> userMembershipList){
        this.membershipNo = membershipNo;
        this.membershipName = membershipName;
        this.userMembershipList = userMembershipList;
    }
}
