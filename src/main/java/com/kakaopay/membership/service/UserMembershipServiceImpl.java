package com.kakaopay.membership.service;

import com.kakaopay.membership.dto.MembershipDto;
import com.kakaopay.membership.dto.request.RegisterMembershipRequest;
import com.kakaopay.membership.entity.Membership;
import com.kakaopay.membership.entity.User;
import com.kakaopay.membership.entity.UserMembership;
import com.kakaopay.membership.repository.MembershipRepository;
import com.kakaopay.membership.repository.UserMembershipRepository;
import com.kakaopay.membership.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserMembershipServiceImpl implements UserMembershipService {

    private final UserMembershipRepository userMembershipRepository;
    private final UserRepository userRepository;
    private final MembershipRepository membershipRepository;

    @Override
    public List<MembershipDto> getMembershipList(String userId) {
        User user = userRepository.findByUserId(userId).orElseThrow(PersistenceException::new);
        List<UserMembership> userMembershipList = userMembershipRepository.findAllByUser(user);
        return userMembershipList.
                stream().map(s ->
                MembershipDto.builder()
                        .seq(s.getUserMembershipNo())
                        .membershipId(s.getMembershipId())
                        .userId(s.getUser().getUserId())
                        .membershipName(s.getMembership().getMembershipName())
                        .startDate(s.getCreatedDateTime())
                        .membershipStatus(s.getMembershipStatus())
                        .point(s.getPoint())
                        .build()
        ).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MembershipDto registerMembership(String userId, RegisterMembershipRequest registerMembershipRequest){
        User user = userRepository.findByUserId(userId).orElseThrow(PersistenceException::new);
        Membership membership = membershipRepository
                .findByMembershipName(registerMembershipRequest.getMembershipName())
                .orElseThrow(PersistenceException::new);

        UserMembership userMembership = userMembershipRepository.save(
                UserMembership.builder()
                        .user(user)
                        .membershipId(registerMembershipRequest.getMembershipId())
                        .membership(membership)
                        .membershipStatus("Y")
                        .point(registerMembershipRequest.getPoint())
                        .build()
        );

        return MembershipDto.builder()
                .seq(userMembership.getUserMembershipNo())
                .membershipId(userMembership.getMembershipId())
                .userId(userMembership.getUser().getUserId())
                .membershipName(userMembership.getMembership().getMembershipName())
                .startDate(userMembership.getCreatedDateTime())
                .membershipStatus(userMembership.getMembershipStatus())
                .point(userMembership.getPoint())
                .build();
    }

    @Override
    @Transactional
    public boolean deleteMembership(String userId, String membershipId) {
        User user = userRepository.findByUserId(userId).orElseThrow(PersistenceException::new);
        UserMembership userMembership = userMembershipRepository.findByUserAndMembershipId(user, membershipId).orElseThrow(PersistenceException::new);
        return userMembership.deactivateMembership();
    }

    @Override
    public MembershipDto getDetailMembership(String userId, String membershipId) {
        User user = userRepository.findByUserId(userId).orElseThrow(PersistenceException::new);
        UserMembership userMembership = userMembershipRepository.findByUserAndMembershipId(user, membershipId).orElseThrow(PersistenceException::new);
        return MembershipDto.builder()
                .seq(userMembership.getUserMembershipNo())
                .membershipId(userMembership.getMembershipId())
                .userId(userMembership.getUser().getUserId())
                .membershipName(userMembership.getMembership().getMembershipName())
                .startDate(userMembership.getCreatedDateTime())
                .membershipStatus(userMembership.getMembershipStatus())
                .point(userMembership.getPoint())
                .build();
    }

    @Override
    @Transactional
    public boolean accumulatePoint(String userId, String membershipId, int amount) {
        User user = userRepository.findByUserId(userId).orElseThrow(PersistenceException::new);
        UserMembership userMembership = userMembershipRepository.findByUserAndMembershipId(user, membershipId).orElseThrow(PersistenceException::new);
        return userMembership.accumulatePoint(amount);
    }


}
