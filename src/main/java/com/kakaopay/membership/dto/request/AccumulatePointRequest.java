package com.kakaopay.membership.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AccumulatePointRequest {

    private String membershipId;
    private int amount;

}
