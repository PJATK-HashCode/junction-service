package com.junctionservice.junctionservice.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
public class Player {
    private Long id;
    private Long initialBillAmount;
    private Long finalBillAmount;
    private Double percentShare;
    private String name;
    private Long avatarId;
    private Long score = 0L;
    private String initialPercentage;
    private String finalPercentage;
    private Map<Long,Boolean> correctAnswersPerRound = new HashMap<>();
    private Map<Long,Long> timeToAnswerPerRound = new HashMap<>();
}
