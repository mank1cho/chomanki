package com.kakaopay.membership.controller;


import com.kakaopay.membership.dto.response.MembershipListResponse;
import com.kakaopay.membership.service.UserMembershipService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.bridge.Message;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class MembershipApiController {

    private final UserMembershipService membershipService;

    @GetMapping("/v1/membership")
    public ResponseEntity getMembership(
            @RequestHeader(value = "Content-Type") String contentType,
            @RequestHeader(value = "X-USER-ID") String xUserId
    ){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        return new ResponseEntity(new MembershipListResponse(true, membershipService.getMembershipList(xUserId), null), headers, HttpStatus.OK);
    }

}
