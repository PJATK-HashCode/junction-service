package com.junctionservice.junctionservice.service;

import com.junctionservice.junctionservice.model.Competition;
import com.junctionservice.junctionservice.model.Game;
import com.junctionservice.junctionservice.model.Player;
import com.junctionservice.junctionservice.model.response.MatchResponse;
import org.springframework.stereotype.Service;

@Service
public class GameService {


    private static long competitionId = 0;

    public GameService() {


    }

    public MatchResponse startNewGame(Competition competition, Game game){
        MatchResponse matchResponse = new MatchResponse();
        competition.setCompetitionCode(String.valueOf(competitionId));
        competition.getPlayers().put(competition.getAdmin().getId(),competition.getAdmin());

        game.competition.put(competitionId,competition);
        competitionId++;
        return matchResponse;
    }


    public MatchResponse joinCompetition(long competitionId, long avatarId, String name){
        MatchResponse matchResponse = new MatchResponse();
        Competition competition = Game.competition.get(competitionId);

        for (int i = 1; i < competition.getNumberOfPlayers()
                ; i++) {
            Player player = new Player();

        }

        return matchResponse;
    }


}
