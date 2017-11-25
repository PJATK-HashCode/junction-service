package com.junctionservice.junctionservice.service.minichallenge;

import com.junctionservice.junctionservice.model.minichallenge.arithmetic.ArithmeticEquation;
import com.junctionservice.junctionservice.model.minichallenge.arithmetic.MathOperator;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Data
public class ArithmeticEquationService implements IMiniChallengeService {

    @Autowired
    private MathOperatorMapper mathOperatorMapper;
    private ArithmeticEquation arithmeticEquationGame;

    public ArithmeticEquationService() {
        this.arithmeticEquationGame = new ArithmeticEquation();
    }

    @Override
    public int challengeId() {
        return arithmeticEquationGame.id();
    }

    @Override
    public String challengeName() {
        return arithmeticEquationGame.name();
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
