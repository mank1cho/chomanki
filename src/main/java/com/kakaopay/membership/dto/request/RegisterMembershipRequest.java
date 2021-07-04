package com.kakaopay.membership.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegisterMembershipRequest {

    private String membershipId;
    private String membershipName;
    private int point;

}
