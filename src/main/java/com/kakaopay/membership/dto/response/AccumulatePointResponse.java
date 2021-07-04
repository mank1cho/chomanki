package com.kakaopay.membership.dto.response;

import com.kakaopay.membership.dto.CommonError;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AccumulatePointResponse {
    private boolean success;
    private boolean response;
    private CommonError error;
}
