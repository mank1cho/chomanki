package com.kakaopay.membership.service;

import com.kakaopay.membership.dto.MembershipDto;

import java.util.List;

public interface UserMembershipService {

    public List<MembershipDto> getMembershipList(String userId);

}
