package com.junctionservice.junctionservice.model.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ResponsePlayer
{
    private String name;
    private String avatarId;

    private String initialBillAmount;
    private String finalBillAmount;
    private String percentShare;
}
