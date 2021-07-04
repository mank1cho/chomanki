package com.kakaopay.membership.service;

import com.kakaopay.membership.dto.MembershipDto;
import com.kakaopay.membership.dto.request.RegisterMembershipRequest;

import java.util.List;

public interface UserMembershipService {

    List<MembershipDto> getMembershipList(String userId);
    MembershipDto registerMembership(String userId, RegisterMembershipRequest registerMembershipRequest);
    boolean deleteMembership(String userId, String membershipId);
    MembershipDto getDetailMembership(String userId, String membershipId);
    boolean accumulatePoint(String userId, String membershipId, int amount);
}
