package com.junctionservice.junctionservice.model;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
public final class Game {
    private final static Map<Long,Match> set = new HashMap<>();
    private static Game game = null;

    protected Game() {
        set.put(1L, new Match());
    }

    public static Game getGame() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }
}