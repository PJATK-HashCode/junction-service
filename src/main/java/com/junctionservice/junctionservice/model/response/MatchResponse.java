package com.junctionservice.junctionservice.model.response;


import com.junctionservice.junctionservice.model.Player;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MatchResponse {

    private Long competitionId;
    private List<Player> responsePlayers = new ArrayList<>();
    private Boolean isFinished;
    private Boolean runGame;
    private String currentPlayerId;

}
