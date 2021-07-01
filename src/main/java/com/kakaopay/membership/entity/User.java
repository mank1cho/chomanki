package com.kakaopay.membership.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "USER")
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<UserMembership> userMembershipList = new ArrayList<>();

}
