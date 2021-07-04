package com.kakaopay.membership.repository;

import com.kakaopay.membership.entity.Membership;
import com.kakaopay.membership.entity.User;
import com.kakaopay.membership.entity.UserMembership;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

public interface UserMembershipRepository extends JpaRepository<UserMembership, Long> {
    List<UserMembership> findAllByUser(User user);
    Optional<UserMembership> findByUserAndMembershipId(User user, String membershipId);
}
