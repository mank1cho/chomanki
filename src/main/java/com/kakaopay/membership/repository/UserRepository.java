package com.kakaopay.membership.repository;

import com.kakaopay.membership.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
