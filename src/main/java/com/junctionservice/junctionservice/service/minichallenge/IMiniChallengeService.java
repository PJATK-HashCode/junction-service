package com.junctionservice.junctionservice.service.minichallenge;

import java.util.List;
import java.util.Map;

public interface IMiniChallengeService {

    Integer challengeId();

    String challengeName();

    String correctAnswer();

    String question();

    List<String> possibleAnswers();

    Map<String,String> multipleParameterQuestion();
}
