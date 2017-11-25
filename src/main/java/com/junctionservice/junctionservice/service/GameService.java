package com.junctionservice.junctionservice.service;

import com.junctionservice.junctionservice.model.Competition;
import com.junctionservice.junctionservice.model.Game;
import com.junctionservice.junctionservice.model.Player;
import com.junctionservice.junctionservice.model.response.MatchResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class GameService {


    private static long competitionId = 0;

    public GameService() {
    }

    public MatchResponse startNewGame(Competition competition, Game game){
        MatchResponse matchResponse = new MatchResponse();
        competition.setCompetitionCode(String.valueOf(competitionId));
        competition.getAdmin().setId(0L);
        competition.getPlayers().put(competition.getAdmin().getId(),competition.getAdmin());

        game.competition.put(competitionId,competition);
        competitionId++;
        matchResponse.setCompetitionId(competitionId);
        matchResponse.setCurrentPlayerId(competition.getAdmin());
        return matchResponse;
    }


    public MatchResponse joinCompetition(long currentId, long avatarId, String name, BigDecimal initialAmount) throws InterruptedException {
        MatchResponse matchResponse = new MatchResponse();
        Long numberOfPlayers = (long) Game.competition.get(currentId).getNumberOfPlayers();

        for (int i = 1; i < numberOfPlayers; i++) {
            if (Game.competition.get(currentId).getPlayers().get((long)i) == null)
            {
                Player player = new Player();
                player.setAvatarId(avatarId);
                player.setId((long)i);
                player.setName(name);
                player.setInitialBillAmount(initialAmount);

                matchResponse.setCurrentPlayerId(player);
                Game.competition.get(currentId).getPlayers().put((long) i,player);
                break;
            }
        }
        while(Game.competition.get(currentId).getPlayers().size() != numberOfPlayers){
            Thread.sleep(30);
        }
        matchResponse.setCompetitionId(currentId);
        matchResponse.getResponsePlayers().addAll(Game.competition.get(currentId).getPlayers().values());
        matchResponse.setRunGame(true);
        return matchResponse;
    }

    public MatchResponse startMinigames(long currentId, long playerId) throws InterruptedException {
        MatchResponse matchResponse = new MatchResponse();
        Player currentPlayer = Game.competition.get(currentId).getPlayers().get(playerId);

        List<Player> listOfPlayers = new ArrayList<>();
        listOfPlayers.addAll(Game.competition.get(currentId).getPlayers().values());
        List<Player> listOfConfirmedPlayers = new ArrayList<>();

        listOfConfirmedPlayers.add(currentPlayer);

        while(listOfConfirmedPlayers.size() != listOfPlayers.size()){
            Thread.sleep(30);
        }
        // SELECT GAME HERE


        matchResponse.setCompetitionId(currentId);
        matchResponse.getResponsePlayers().addAll(Game.competition.get(currentId).getPlayers().values());
        matchResponse.setGameName("TUTAJ WYLOSUJEMY NAZWE GRY ELO");


        return matchResponse;
    }
}
