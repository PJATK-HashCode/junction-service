package com.junctionservice.junctionservice.model.minichallenge.arithmetic;

import com.junctionservice.junctionservice.model.minichallenge.IMiniChallenge;
import lombok.Data;

@Data
public class ArithmeticEquation implements IMiniChallenge {

    private int id;
    private String name;
    private long firstNumber;
    private long secondNumber;
    private long result;
    private MathOperator mathOperator;

    @Override
    public int id() {
        return this.id;
    }

    @Override
    public String name() {
        return this.name;
    }
}
