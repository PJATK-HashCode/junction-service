package com.junctionservice.junctionservice.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Player {
    private long id;
    private BigDecimal billAmount;
    private String name;
    private long avatarId;
}
