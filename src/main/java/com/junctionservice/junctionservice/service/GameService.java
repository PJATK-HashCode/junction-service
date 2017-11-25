package com.junctionservice.junctionservice.service;

import com.junctionservice.junctionservice.model.Competition;
import com.junctionservice.junctionservice.model.Game;
import com.junctionservice.junctionservice.model.Player;
import com.junctionservice.junctionservice.model.response.MatchResponse;
import com.junctionservice.junctionservice.service.minichallenge.IMiniChallengeService;
import com.junctionservice.junctionservice.service.minichallenge.MiniChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class GameService {

    private MiniChallengeService miniChallengeService;

    private static long competitionId = 0;

    @Autowired
    public GameService(MiniChallengeService miniChallengeService) {
        this.miniChallengeService = miniChallengeService;
    }

    public MatchResponse startNewGame(Competition competition, Game game) {
        MatchResponse matchResponse = new MatchResponse();
        competition.setCompetitionCode(String.valueOf(competitionId));
        competition.getAdmin().setId(0L);
        competition.getPlayers().put(competition.getAdmin().getId(), competition.getAdmin());

        game.competition.put(competitionId, competition);
        competitionId++;
        matchResponse.setCompetitionId(competitionId);
        matchResponse.setCurrentPlayerId(competition.getAdmin());
        return matchResponse;
    }


    public MatchResponse joinCompetition(long currentId, long avatarId, String name, BigDecimal initialAmount) throws InterruptedException {
        MatchResponse matchResponse = new MatchResponse();
        Long numberOfPlayers = (long) getGame(currentId).getNumberOfPlayers();

        setAllPlayers(currentId, avatarId, name, initialAmount, matchResponse, numberOfPlayers);

        while (getGame(currentId).getPlayers().size() != numberOfPlayers) {
            Thread.sleep(30);
        }
        matchResponse.setCompetitionId(currentId);
        matchResponse.getResponsePlayers().addAll(getGame(currentId).getPlayers().values());
        matchResponse.setRunGame(true);
        return matchResponse;
    }



    public MatchResponse startMinigames(long currentId, long playerId) throws InterruptedException {
        MatchResponse matchResponse = new MatchResponse();
        Player currentPlayer = getGame(currentId).getPlayers().get(playerId);

        List<Player> listOfPlayers = new ArrayList<>();
        listOfPlayers.addAll(getGame(currentId).getPlayers().values());
        List<Player> listOfConfirmedPlayers = new ArrayList<>();

        listOfConfirmedPlayers.add(currentPlayer);

        while (listOfConfirmedPlayers.size() != listOfPlayers.size()) {
            Thread.sleep(30);
        }

        IMiniChallengeService miniChallenge = miniChallengeService.selectRandomChallenge();


        if (getGame(currentId).getNumberOfRounds() == null){
            getGame(currentId).setNumberOfRounds(1);
        }

        matchResponse.setCompetitionId(currentId);
        matchResponse.getResponsePlayers().addAll(getGame(currentId).getPlayers().values());
        matchResponse.setCurrentPlayerId(currentPlayer);
        matchResponse.setGameName(miniChallenge.challengeName());
        if (miniChallenge.challengeName().equalsIgnoreCase("Solve Equation")) {
            matchResponse.getSolveEquatationState().setQuestion(miniChallenge.question());
            matchResponse.getSolveEquatationState().setPossibleAnswerList(miniChallenge.possibleAnswers());
        }
        if (miniChallenge.challengeName().equalsIgnoreCase("colourpicker"))
        {

        }
        if (getGame(currentId).getNumberOfRounds() >=  getGame(currentId).getCurrentRound()){
            matchResponse.setIsNextRound(false);
        }else {
            matchResponse.setIsNextRound(true);
        }

        return matchResponse;
    }















    private Competition getGame(long currentId) {
        return Game.competition.get(currentId);
    }

    private void setAllPlayers(long currentId, long avatarId, String name, BigDecimal initialAmount, MatchResponse matchResponse, Long numberOfPlayers) {
        for (int i = 0; i < numberOfPlayers; i++) {
            if (getGame(currentId).getPlayers().get((long) i) == null) {
                Player player = new Player();
                player.setAvatarId(avatarId);
                player.setId((long) i);
                player.setName(name);
                player.setInitialBillAmount(initialAmount);
                matchResponse.setCurrentPlayerId(player);

                getGame(currentId).getPlayers().put((long) i, player);
                break;
            }
        }
    }


}
