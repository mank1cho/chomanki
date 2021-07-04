package com.kakaopay.membership;

import com.kakaopay.membership.entity.Membership;
import com.kakaopay.membership.entity.User;
import com.kakaopay.membership.entity.UserMembership;
import com.kakaopay.membership.repository.MembershipRepository;
import com.kakaopay.membership.repository.UserMembershipRepository;
import com.kakaopay.membership.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserMembershipRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MembershipRepository membershipRepository;

    @Autowired
    UserMembershipRepository userMembershipRepository;

    @Test
    public void userMembership_등록테스트(){

        User user = User.builder()
                .userId("test1")
                .build();

        Membership membership = Membership.builder()
                .membershipId("cj")
                .membershipName("cjone")
                .build();

        UserMembership userMembership = UserMembership.builder()
                .user(user)
                .membership(membership)
                .membershipStatus("Y")
                .point(2150L)
                .build();

        userRepository.save(user);
        membershipRepository.save(membership);
        userMembershipRepository.save(userMembership);

    }

}
