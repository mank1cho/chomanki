package com.kakaopay.membership.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "user")
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "user_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<UserMembership> userMembershipList = new ArrayList<>();

    @Builder
    public User(Long id, String userId){
        this.id = id;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                '}';
    }
}
