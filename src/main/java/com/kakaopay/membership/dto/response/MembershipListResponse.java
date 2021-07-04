package com.kakaopay.membership.dto.response;

import com.kakaopay.membership.dto.MembershipDto;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MembershipListResponse implements Serializable {

    private boolean success;
    private List<MembershipDto> membershipDtoList;
    private String error;

}
