package com.kakaopay.membership.service;

import com.kakaopay.membership.dto.MembershipDto;
import com.kakaopay.membership.entity.User;
import com.kakaopay.membership.entity.UserMembership;
import com.kakaopay.membership.repository.UserMembershipRepository;
import com.kakaopay.membership.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserMembershipServiceImpl implements UserMembershipService {

    private final UserMembershipRepository userMembershipRepository;
    private final UserRepository userRepository;

    @Override
    public List<MembershipDto> getMembershipList(String userId) {
        User user = userRepository.findByUserId(userId).orElseThrow(PersistenceException::new);
        List<UserMembership> userMembershipList = userMembershipRepository.findAllByUser(user);
        return userMembershipList.
                stream().map(s ->
                    new MembershipDto(
                            s.getId(),
                            s.getMembership().getMembershipId(),
                            s.getUser().getUserId(),
                            s.getMembership().getMembershipName(),
                            s.getCreatedDateTime(),
                            s.getMembershipStatus(),
                            s.getPoint()
                    )
        ).collect(Collectors.toList());
    }
}
