package com.kakaopay.membership.dto.response;

import com.kakaopay.membership.dto.CommonError;
import com.kakaopay.membership.dto.MembershipDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetDetailMembershipResponse {

    private boolean success;
    private MembershipDto response;
    private CommonError error;

}
