package com.kakaopay.membership.dto.response;

import com.kakaopay.membership.dto.CommonError;
import com.kakaopay.membership.dto.MembershipDto;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
public class GetMembershipListResponse {

    private boolean success;
    private List<MembershipDto> response;
    private CommonError error;

}
