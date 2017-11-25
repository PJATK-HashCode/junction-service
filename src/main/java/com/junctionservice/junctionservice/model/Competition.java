package com.junctionservice.junctionservice.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
public class Competition {
    private String competitionCode;
    private Player admin;
    private BigDecimal totalBill;
    private SolveEquatationState solveEquatationState;
    private Boolean fixedShare;
    private Map<Long, Player> players = new HashMap<>();
    private Integer numberOfPlayers;
    private Integer numberOfRounds;
    private Ratio ratio;
    private Integer currentRound;
}
