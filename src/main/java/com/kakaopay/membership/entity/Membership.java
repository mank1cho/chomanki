package com.kakaopay.membership.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@Table(name = "membership")
@NoArgsConstructor
public class Membership {

    @Id
    @Column(name = "membership_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "membership_id")
    private String membershipId;

    @Column(name = "membership_name")
    private String membershipName;

    @OneToMany(mappedBy = "membership")
    private List<UserMembership> userMembershipList = new ArrayList<>();

    @Builder
    public Membership(Long id, String membershipId, String membershipName, List<UserMembership> userMembershipList){
        this.id = id;
        this.membershipId = membershipId;
        this.userMembershipList = userMembershipList;
    }

}
