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
        return matchResponse;
    }


    public MatchResponse joinCompetition(long competitionId, long avatarId, String name, BigDecimal initialAmount) throws InterruptedException {
        MatchResponse matchResponse = new MatchResponse();
        Competition competition = Game.competition.get(competitionId);

        Long numberOfPlayers = new Long(competition.getNumberOfPlayers());

        for (int i = 1; i < numberOfPlayers
                ; i++) {
            if (competition.getPlayers().get((long)i) == null)
            {
                Player player = new Player();
                player.setAvatarId(avatarId);
                player.setId(i);
                player.setName(name);
                player.setInitialBillAmount(initialAmount);



                competition.getPlayers().put((long) i,player);
                break;
            }
        }

        while(competition.getPlayers().get(numberOfPlayers) != null){
            Thread.sleep(10);
        }

        matchResponse.setCompetitionId(competitionId);
        matchResponse.getResponsePlayers().addAll(competition.getPlayers().values());
        matchResponse.setRunGame(true);
        return matchResponse;
    }


}
