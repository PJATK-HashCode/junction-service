package com.junctionservice.junctionservice.model.minichallenge.arithmetic;

import com.junctionservice.junctionservice.model.minichallenge.IMiniChallenge;
import lombok.Data;

@Data
public class ArithmeticEquation implements IMiniChallenge {

    private int id;
    private String name;
    private double firstNumber;
    private double secondNumber;
    private double result;
    private MathOperator mathOperator;

    @Override
    public int id() {
        return 0;
    }

    @Override
    public String name() {
        return null;
    }
}
