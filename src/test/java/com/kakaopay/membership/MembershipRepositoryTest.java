package com.kakaopay.membership;

import com.kakaopay.membership.entity.Membership;
import com.kakaopay.membership.repository.MembershipRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MembershipRepositoryTest {

    @Autowired
    MembershipRepository membershipRepository;


    @Test
    public void membership_등록테스트(){

        Membership membership1 = Membership.builder()
                .membershipName("happypoint")
                .build();
        Membership membership2 = Membership.builder()
                .membershipName("shinsegaepoint")
                .build();
        Membership membership3 = Membership.builder()
                .membershipName("cjone")
                .build();

        membershipRepository.save(membership1);
        membershipRepository.save(membership2);
        membershipRepository.save(membership3);
    }

}
