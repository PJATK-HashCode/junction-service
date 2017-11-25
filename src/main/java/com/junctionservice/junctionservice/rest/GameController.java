package com.junctionservice.junctionservice.rest;

import com.junctionservice.junctionservice.model.Competition;
import com.junctionservice.junctionservice.model.Game;
import com.junctionservice.junctionservice.model.response.MatchResponse;
import com.junctionservice.junctionservice.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class GameController {

    GameService gameService;

    private Game game;

    @Autowired
    public GameController(GameService gameService) {
        game = Game.getGame();
        this.gameService = gameService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<MatchResponse> startGame(@RequestBody Competition competition){
        MatchResponse matchResponse = gameService.startNewGame(competition,game);
        return new ResponseEntity(matchResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{competitionId}/join", method = RequestMethod.GET)
    public ResponseEntity<MatchResponse> joinCompetition(@PathVariable("competitionId") Long competitionId,
                                                         @RequestParam("name") String name,
                                                         @RequestParam("avatarId") Long avatarId,
                                                         @RequestParam("initialAmount")BigDecimal initialAmount) throws InterruptedException {
        MatchResponse matchResponse = gameService.joinCompetition(competitionId,avatarId,name,initialAmount);

        return new ResponseEntity<MatchResponse>(matchResponse, HttpStatus.OK);
    }
}
