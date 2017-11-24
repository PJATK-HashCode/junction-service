package com.junctionservice.junctionservice.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public final class Game {
    private final static Map<Long,Competition> set = new HashMap<>();
    private static Game game = null;

    protected Game() {
        set.put(1L, new Competition());
    }

    public static Game getGame() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }
}