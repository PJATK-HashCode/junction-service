package com.junctionservice.junctionservice.model;

import com.junctionservice.junctionservice.service.minichallenge.IMiniChallengeService;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Competition {
    private String competitionCode;
    private Player player;
    private Long totalBill;
    private IMiniChallengeService miniChallenge;
    private Boolean equalSplit;
    private Map<Long, Player> players = new HashMap<>();
    private Integer numberOfPlayers;
    private Integer numberOfRounds;
    private Ratio ratio;
    private Long rate = 2L;
    private Integer currentRound;

    private List<Player> listOfConfirmedPlayers = new ArrayList<>();
}
