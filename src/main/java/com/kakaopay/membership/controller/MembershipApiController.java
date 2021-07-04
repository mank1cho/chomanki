package com.kakaopay.membership.controller;


import com.kakaopay.membership.dto.CommonError;
import com.kakaopay.membership.dto.request.AccumulatePointRequest;
import com.kakaopay.membership.dto.request.RegisterMembershipRequest;
import com.kakaopay.membership.dto.response.*;
import com.kakaopay.membership.service.UserMembershipService;
import com.kakaopay.membership.validator.RequestFieldValidate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class MembershipApiController {

    private final UserMembershipService membershipService;
    private static final RequestFieldValidate validator = RequestFieldValidate.getInstance();

    @GetMapping("/v1/membership")
    public ResponseEntity getMembershipList(
            @RequestHeader(value = "Content-Type") String contentType,
            @RequestHeader(value = "X-USER-ID") String xUserId
    ) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        CommonError commonError = validator.validator(xUserId);
        if(commonError != null){
            return new ResponseEntity(
                    GetMembershipListResponse.builder()
                            .success(false)
                            .response(null)
                            .error(commonError)
                            .build(),
                    headers,
                    HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(
                GetMembershipListResponse.builder()
                        .success(true)
                        .response(membershipService.getMembershipList(xUserId))
                        .error(null)
                        .build(),
                headers,
                HttpStatus.OK);
    }

    @PostMapping("/v1/membership")
    public ResponseEntity registerMembership(
            @RequestHeader(value = "Content-Type") String contentType,
            @RequestHeader(value = "X-USER-ID") String xUserId,
            @RequestBody RegisterMembershipRequest registerMembershipRequest
            ){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        CommonError commonError = validator.validator(xUserId, registerMembershipRequest);
        if(commonError != null){
            return new ResponseEntity(
                    GetMembershipListResponse.builder()
                            .success(false)
                            .response(null)
                            .error(commonError)
                            .build(),
                    headers,
                    HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(
                RegisterMembershipResponse.builder()
                        .success(true)
                        .response(membershipService.registerMembership(xUserId, registerMembershipRequest))
                        .build(),
                headers,
                HttpStatus.CREATED);
    }

    @DeleteMapping("/v1/membership/{membershipId}")
    public ResponseEntity deleteMembership(
            @PathVariable("membershipId") String membershipId,
            @RequestHeader(value = "Content-Type") String contentType,
            @RequestHeader(value = "X-USER-ID") String xUserId
    ){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        CommonError commonError = validator.validator(xUserId, membershipId);
        if(commonError != null){
            return new ResponseEntity(
                    GetMembershipListResponse.builder()
                            .success(false)
                            .response(null)
                            .error(commonError)
                            .build(),
                    headers,
                    HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(
                DeleteMembershipResponse.builder()
                        .success(true)
                        .response(membershipService.deleteMembership(xUserId, membershipId))
                        .build(),
                HttpStatus.ACCEPTED);
    }

    @GetMapping("/v1/membership/{membershipId}")
    public ResponseEntity getDetailMembership(
            @PathVariable("membershipId") String membershipId,
            @RequestHeader(value = "Content-Type") String contentType,
            @RequestHeader(value = "X-USER-ID") String xUserId
    ){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        CommonError commonError = validator.validator(xUserId, membershipId);
        if(commonError != null){
            return new ResponseEntity(
                    GetMembershipListResponse.builder()
                            .success(false)
                            .response(null)
                            .error(commonError)
                            .build(),
                    headers,
                    HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(
                GetDetailMembershipResponse.builder()
                        .success(true)
                        .response(membershipService.getDetailMembership(xUserId, membershipId))
                        .error(null)
                        .build(),
                headers,
                HttpStatus.OK);
    }

    @PutMapping("/v1/membership/point")
    public ResponseEntity accumulatePoint(
            @RequestHeader(value = "Content-Type") String contentType,
            @RequestHeader(value = "X-USER-ID") String xUserId,
            @RequestBody AccumulatePointRequest accumulatePointRequest
    ){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        CommonError commonError = validator.validator(xUserId, accumulatePointRequest);
        if(commonError != null){
            return new ResponseEntity(
                    GetMembershipListResponse.builder()
                            .success(false)
                            .response(null)
                            .error(commonError)
                            .build(),
                    headers,
                    HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(
                AccumulatePointResponse.builder()
                        .success(true)
                        .response(membershipService.accumulatePoint(xUserId, accumulatePointRequest.getMembershipId(), accumulatePointRequest.getAmount()))
                        .error(null)
                        .build(),
                headers,
                HttpStatus.OK);
    }
}
