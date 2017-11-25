package com.junctionservice.junctionservice.rest;

import com.junctionservice.junctionservice.model.Competition;
import com.junctionservice.junctionservice.model.Game;
import com.junctionservice.junctionservice.model.response.MatchResponse;
import com.junctionservice.junctionservice.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {

    GameService gameService;

    public Game game;

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
}
