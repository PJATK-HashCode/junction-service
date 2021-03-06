package com.junctionservice.junctionservice.service.minichallenge;

import com.junctionservice.junctionservice.model.minichallenge.arithmetic.ArithmeticEquation;
import com.junctionservice.junctionservice.model.minichallenge.arithmetic.MathOperator;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;


@Service
@Data
public class SolveEquationService implements IMiniChallengeService {

    @Autowired
    private MathOperatorMapper mathOperatorMapper;
    private ArithmeticEquation arithmeticEquationGame;
    private final int challengeId = 1;
    private final String challengeName = "Solve Equation";

    public SolveEquationService() {
        this.arithmeticEquationGame = new ArithmeticEquation();
        this.arithmeticEquationGame.setId(challengeId);
        this.arithmeticEquationGame.setName(challengeName);
    }

    @Override
    public Integer challengeId() {
        return arithmeticEquationGame.id();
    }

    @Override
    public String challengeName() {
        return arithmeticEquationGame.name();
    }

    @Override
    public String correctAnswer() {
        return arithmeticEquationGame.getResult().toString();
    }

    @Override
    public String question() {
        Random random = new Random();
        int x = random.nextInt(10000);
        int y = random.nextInt(10000);
        MathOperator[] operators = MathOperator.values();
        MathOperator operator = operators[random.nextInt(operators.length)];
        BigDecimal result = mathOperatorMapper.operatorMapper(operator, x, y);
        arithmeticEquationGame.setResult(result);
        String operatorSymbol = mathOperatorMapper.getOperator();
        return Integer.toString(x) + " " + operatorSymbol + " " + Integer.toString(y) + " = ?";
    }

    @Override
    public List<String> possibleAnswers() {
        List<String> answers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            BigDecimal incorrectNumber = BigDecimal.valueOf(random.nextInt(10000));
            answers.add(incorrectNumber.toString());
        }

        answers.add(arithmeticEquationGame.getResult().toString());
        Collections.shuffle(answers);
        return answers;
    }

    @Override
    public Map<String, String> multipleParameterQuestion() {
        return null;
    }


}
