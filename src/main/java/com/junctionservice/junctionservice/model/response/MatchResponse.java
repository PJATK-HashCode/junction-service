package com.junctionservice.junctionservice.model.response;


import com.junctionservice.junctionservice.model.Player;
import com.junctionservice.junctionservice.model.SolveEquatationState;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MatchResponse {

    private Long competitionId;
    private List<Player> responsePlayers = new ArrayList<>();
    private Boolean isFinished;
    private Boolean runGame;
    private Player currentPlayer;
    private String gameName;
    private Boolean isNextRound;
    private String question;
    private List<String> possibleAnswerList;
    private String answer;

}
