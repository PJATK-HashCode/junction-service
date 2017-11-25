package com.junctionservice.junctionservice.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Player {
    private long id;
    private BigDecimal initialBillAmount;
    private BigDecimal finalBillAmount;
    private Double percentShare;
    private String name;
    private long avatarId;
}
