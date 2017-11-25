package com.junctionservice.junctionservice.rest;

import com.junctionservice.junctionservice.model.Competition;
import com.junctionservice.junctionservice.model.Game;
import com.junctionservice.junctionservice.model.Player;
import com.junctionservice.junctionservice.model.response.InitialResponse;
import com.junctionservice.junctionservice.model.response.MatchResponse;
import com.junctionservice.junctionservice.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/game")
public class GameController {

    GameService gameService;

    private Game game;

    @Autowired
    public GameController(GameService gameService) {
        game = Game.getGame();
        this.gameService = gameService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<MatchResponse> startGame(@RequestBody Competition competition) {
        MatchResponse matchResponse = gameService.startNewGame(competition, game);
        return new ResponseEntity(matchResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{competitionId}/join", method = RequestMethod.POST)
    public ResponseEntity<MatchResponse> joinCompetition(@PathVariable("competitionId") Long competitionId,
                                                         @RequestBody Player player) throws InterruptedException {
        MatchResponse matchResponse = gameService.joinCompetition(competitionId,player.getName(),player.getInitialBillAmount());
        return new ResponseEntity<>(matchResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{competitionId}/selectMinigame", method = RequestMethod.GET)
    public ResponseEntity<MatchResponse> startMinigame(@PathVariable("competitionId") Long competitionId,
                                                       @RequestBody Player player) throws InterruptedException {
        MatchResponse matchResponse = gameService.startMinigames(competitionId, player.getId());
        return new ResponseEntity<MatchResponse>(matchResponse, HttpStatus.OK);
    }



    @RequestMapping(value = "/ask", method = RequestMethod.POST)
    public ResponseEntity<InitialResponse> checkIfSameGameExistsAndDoInputInitialBill(@RequestParam("gameId") Long gameId) {
        InitialResponse initialResponse = gameService.checkIfSameGameExistsAndDoInputInitialBill(gameId);
        return new ResponseEntity<InitialResponse>(initialResponse, HttpStatus.OK);
    }
}
