package com.junctionservice.junctionservice.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
public class Competition {
    private String competitionCode;
    private Player admin;
    private BigDecimal totalBill;
    private StateOfGame stateOfGame;
    private Boolean fixedShare;
    private Map<Long, Player> players;
    private int numberOfPlayers;


}
