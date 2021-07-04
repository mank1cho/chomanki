package com.kakaopay.membership.dto.response;

import com.kakaopay.membership.dto.CommonError;
import com.kakaopay.membership.dto.MembershipDto;
import lombok.*;

@Getter
@Setter
@Builder
public class RegisterMembershipResponse {

    private boolean success;
    private MembershipDto response;
    private CommonError error;

}
