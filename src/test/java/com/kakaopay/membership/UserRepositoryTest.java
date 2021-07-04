package com.kakaopay.membership;

import com.kakaopay.membership.entity.User;
import com.kakaopay.membership.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;


    @Test
    public void user_등록테스트(){

        User user1 = User.builder()
                .userId("test1")
                .build();

        User user2 = User.builder()
                .userId("test2")
                .build();

        User user3 = User.builder()
                .userId("test3")
                .build();


        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        List<User> users = userRepository.findAll();

        User savedUser = users.get(0);

        Assertions.assertEquals(user1.getUserId(), savedUser.getUserId());

    }

}
