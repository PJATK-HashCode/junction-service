package com.junctionservice.junctionservice.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Competition {
    private String gameCode;
    private Player admin;
    private BigDecimal totalBill;
    private StateOfGame stateOfGame;
    private boolean fixedShare;
    private List<Player> players;


}
