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
@Table(name = "user")
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "user_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;

    @Column(name = "user_id", unique = true)
    private String userId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<UserMembership> userMembershipList = new ArrayList<>();

    @Builder
    public User(Long userNo, String userId, List<UserMembership> userMembershipList){
        this.userNo = userNo;
        this.userId = userId;
        this.userMembershipList = userMembershipList;
    }
}
