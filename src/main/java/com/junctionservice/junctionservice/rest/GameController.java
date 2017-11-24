package com.junctionservice.junctionservice.rest;

import com.junctionservice.junctionservice.model.Game;
import com.junctionservice.junctionservice.model.response.MatchResponse;
import jdk.jfr.ContentType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.security.jca.GetInstance;

import javax.xml.ws.Response;

@RestController
public class GameController {

    public GameController() {
        Game.getGame();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<MatchResponse> startGame(@RequestParam()){
        return;
    }

}
