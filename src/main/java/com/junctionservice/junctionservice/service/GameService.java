package com.junctionservice.junctionservice.service;

import com.junctionservice.junctionservice.model.Competition;
import com.junctionservice.junctionservice.model.Game;
import com.junctionservice.junctionservice.model.Player;
import com.junctionservice.junctionservice.model.response.MatchResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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
        matchResponse.setCompetitionId(competitionId);
        return matchResponse;
    }


    public MatchResponse joinCompetition(long competitionId, long avatarId, String name, BigDecimal initialAmount) throws InterruptedException {
        MatchResponse matchResponse = new MatchResponse();
        Long numberOfPlayers = (long) Game.competition.get(competitionId).getNumberOfPlayers();

        for (int i = 1; i < numberOfPlayers; i++) {
            if (Game.competition.get(competitionId).getPlayers().get((long)i) == null)
            {
                Player player = new Player();
                player.setAvatarId(avatarId);
                player.setId((long)i);
                player.setName(name);
                player.setInitialBillAmount(initialAmount);

                matchResponse.setCurrentPlayerId(String.valueOf(i));
                Game.competition.get(competitionId).getPlayers().put((long) i,player);
                break;
            }
        }
        while(Game.competition.get(competitionId).getPlayers().size() != numberOfPlayers){
            Thread.sleep(10);
        }

        matchResponse.setCompetitionId(competitionId);
        matchResponse.getResponsePlayers().addAll(Game.competition.get(competitionId).getPlayers().values());
        matchResponse.setRunGame(true);
        return matchResponse;
    }


}
