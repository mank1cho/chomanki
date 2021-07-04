package com.kakaopay.membership;

import com.kakaopay.membership.entity.Membership;
import com.kakaopay.membership.entity.User;
import com.kakaopay.membership.entity.UserMembership;
import com.kakaopay.membership.repository.MembershipRepository;
import com.kakaopay.membership.repository.UserMembershipRepository;
import com.kakaopay.membership.repository.UserRepository;
import com.kakaopay.membership.service.UserMembershipService;
import com.kakaopay.membership.service.UserMembershipServiceImpl;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.PersistenceException;
import java.util.List;

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

        User savedUser = userRepository.findByUserId("test1").orElseThrow(PersistenceException::new);

        Membership savedMembership = membershipRepository.findByMembershipName("cjone").orElseThrow(PersistenceException::new);
        Membership savedMembership2 = membershipRepository.findByMembershipName("happypoint").orElseThrow(PersistenceException::new);
        Membership savedMembership3 = membershipRepository.findByMembershipName("shinsegaepoint").orElseThrow(PersistenceException::new);

        UserMembership userMembership = UserMembership.builder()
                .user(savedUser)
                .membershipId("cj")
                .membership(savedMembership)
                .membershipStatus("Y")
                .point(2150)
                .build();

        UserMembership userMembership2 = UserMembership.builder()
                .user(savedUser)
                .membershipId("spc")
                .membership(savedMembership2)
                .membershipStatus("Y")
                .point(2150)
                .build();

        UserMembership userMembership3 = UserMembership.builder()
                .user(savedUser)
                .membershipId("shinsegae")
                .membership(savedMembership3)
                .membershipStatus("Y")
                .point(2150)
                .build();

        //userMembershipRepository.save(userMembership);
        userMembershipRepository.save(userMembership2);
        userMembershipRepository.save(userMembership3);



    }

}
