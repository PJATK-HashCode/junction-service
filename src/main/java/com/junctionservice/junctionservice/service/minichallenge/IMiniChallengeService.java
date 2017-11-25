package com.junctionservice.junctionservice.service.minichallenge;

import java.util.List;

public interface IMiniChallengeService {

    int challengeId();

    String challengeName();

    String correctAnswer();

    String question();

    List<String> possibleAnswers();
}
