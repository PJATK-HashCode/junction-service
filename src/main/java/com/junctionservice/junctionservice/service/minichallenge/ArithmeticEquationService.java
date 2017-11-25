package com.junctionservice.junctionservice.service.minichallenge;

import com.junctionservice.junctionservice.model.minichallenge.arithmetic.ArithmeticEquation;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArithmeticEquationService implements IMiniChallengeService {

    private ArithmeticEquation arithmeticEquationGame;

    public ArithmeticEquationService() {
        this.arithmeticEquationGame = new ArithmeticEquation();
    }

    @Override
    public int challengeId() {
        return arithmeticEquationGame.getId();
    }

    @Override
    public String challengeName() {
        return arithmeticEquationGame.getName();
    }

    @Override
    public String correctAnswer() {
        return null;
    }

    @Override
    public String question() {
        return null;
    }

    @Override
    public List<String> possibleAnswers() {
        return null;
    }
}
