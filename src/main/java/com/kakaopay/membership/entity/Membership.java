package com.kakaopay.membership.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@Table(name = "MEMBERSHIP")
@NoArgsConstructor
public class Membership {

    @Id
    @Column(name = "membership_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "membership_id")
    private String membershipId;

    @Column(name = "membership_name")
    private String membershipName;

    @OneToMany(mappedBy = "membership")
    private List<UserMembership> userMembershipList = new ArrayList<>();

    public Membership setId(Long id) {
        this.id = id;
        return this;
    }

    public Membership setMembershipId(String membershipId) {
        this.membershipId = membershipId;
        return this;
    }

    public Membership setMembershipName(String membershipName) {
        this.membershipName = membershipName;
        return this;
    }

    public Membership setUserMembershipList(List<UserMembership> userMembershipList) {
        this.userMembershipList = userMembershipList;
        return this;
    }
}
