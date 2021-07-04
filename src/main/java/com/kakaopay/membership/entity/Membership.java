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
@Table(name = "membership", uniqueConstraints = {
        @UniqueConstraint(name = "id_name_unique", columnNames = {"membership_id", "membership_name"})
})
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

    @OneToMany(mappedBy = "membership", cascade = CascadeType.PERSIST)
    private List<UserMembership> userMembershipList = new ArrayList<>();

    @Builder Membership(String membershipId, String membershipName){
        this.membershipId = membershipId;
        this.membershipName = membershipName;
    }

}
