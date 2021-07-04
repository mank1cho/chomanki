package com.kakaopay.membership.repository;

import com.kakaopay.membership.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MembershipRepository extends JpaRepository<Membership, Long> {
    Optional<Membership> findByMembershipName(String membershipName);
}
