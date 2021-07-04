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

        Membership membership = Membership.builder()
                .membershipId("cj")
                .membershipName("cjone")
                .build();


        membershipRepository.save(membership);

    }

}
