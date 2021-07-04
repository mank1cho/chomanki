package com.kakaopay.membership.validator;

import com.kakaopay.membership.dto.CommonError;
import com.kakaopay.membership.dto.request.AccumulatePointRequest;
import com.kakaopay.membership.dto.request.RegisterMembershipRequest;

public class RequestFieldValidate {

    private RequestFieldValidate(){};
    private static RequestFieldValidate requestFieldValidator = new RequestFieldValidate();
    public static RequestFieldValidate getInstance(){
        return requestFieldValidator;
    }

    public CommonError validator(String xUserId){
        if(xUserId.equals("")){
            return new CommonError("userId must be provided", 400);
        }
        return null;
    }

    public CommonError validator(String xUserId, RegisterMembershipRequest registerMembershipRequest){
        CommonError commonError = new CommonError(null,400);
        StringBuffer errorMessage = new StringBuffer();

        isEmptyString(xUserId, errorMessage, "userId");
        isEmptyString(registerMembershipRequest.getMembershipId(), errorMessage, "membershipId");
        isEmptyString(registerMembershipRequest.getMembershipName(), errorMessage, "membershipName");

        if(errorMessage.length()==0)
            return null;

        errorMessage.append("must be provided");
        commonError.setMessage(errorMessage.toString());
        return commonError;
    }

    public CommonError validator(String xUserId, String membershipId){
        CommonError commonError = new CommonError(null,400);
        StringBuffer errorMessage = new StringBuffer();

        isEmptyString(xUserId, errorMessage, "userId");
        isEmptyString(membershipId, errorMessage, "membershipId");

        if(errorMessage.length()==0)
            return null;

        errorMessage.append("must be provided");
        commonError.setMessage(errorMessage.toString());
        return commonError;
    }

    public CommonError validator(String xUserId, AccumulatePointRequest accumulatePointRequest){
        CommonError commonError = new CommonError(null,400);
        StringBuffer errorMessage = new StringBuffer();

        isEmptyString(xUserId, errorMessage, "userId");
        isEmptyString(accumulatePointRequest.getMembershipId(), errorMessage, "membershipId");

        if(errorMessage.length()==0)
            return null;

        errorMessage.append("must be provided");
        commonError.setMessage(errorMessage.toString());
        return commonError;
    }

    private void isEmptyString(String field, StringBuffer errorMessage, String param){
        if(field.equals("") || field == null){
            errorMessage.append("[").append(param).append("] ");
        }
    }

}
