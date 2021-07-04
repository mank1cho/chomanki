package com.kakaopay.membership.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
public class MembershipDto implements Serializable {

    private Long seq;
    private String membershipId;
    private String UserId;
    private String membershipName;
    private LocalDateTime startDate;
    private String membershipStatus;
    private Long point;

}
