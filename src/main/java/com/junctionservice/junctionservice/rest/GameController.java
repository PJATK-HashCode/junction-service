package com.junctionservice.junctionservice.rest;

import com.junctionservice.junctionservice.model.Game;
import org.springframework.web.bind.annotation.RestController;
import sun.security.jca.GetInstance;

@RestController
public class GameController {

    public GameController() {
        Game.getGame();
    }

}
