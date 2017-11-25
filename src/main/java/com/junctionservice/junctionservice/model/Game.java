package com.junctionservice.junctionservice.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public final class Game {
    public final static Map<Long,Competition> competition = new HashMap<>();
    private static Game game = null;

    protected Game() {
    }

    public static Game getGame() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }
}