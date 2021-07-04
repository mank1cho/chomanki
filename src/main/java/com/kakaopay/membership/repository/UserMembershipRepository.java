package com.kakaopay.membership.repository;

import com.kakaopay.membership.entity.User;
import com.kakaopay.membership.entity.UserMembership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserMembershipRepository extends JpaRepository<UserMembership, Long> {
    List<UserMembership> findAllByUser(User user);
}
