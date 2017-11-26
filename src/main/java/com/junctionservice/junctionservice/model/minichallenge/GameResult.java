package com.junctionservice.junctionservice.model.minichallenge;


import lombok.Data;

@Data
public class GameResult {
    private Long userId;
    private Object response;
    private long time;
}