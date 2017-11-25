package com.junctionservice.junctionservice.service;

import com.junctionservice.junctionservice.model.Competition;
import com.junctionservice.junctionservice.model.Game;
import com.junctionservice.junctionservice.model.response.MatchResponse;
import org.springframework.stereotype.Service;

@Service
public class GameService {


    private static long gameIdentifier = 0;

    public GameService() {


    }

    public MatchResponse startNewGame(Competition competition, Game game){
        MatchResponse matchResponse = new MatchResponse();
        competition.getAdmin().setId();

        competition.setGameCode(String.valueOf(gameIdentifier));

        game.competition.put(gameIdentifier,competition);
        gameIdentifier++;
        return matchResponse;
    }


}
