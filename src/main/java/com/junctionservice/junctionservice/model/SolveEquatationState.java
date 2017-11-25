package com.junctionservice.junctionservice.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class SolveEquatationState {
    private String question;
    private List<String> possibleAnswerList;
    private String answer;
}
