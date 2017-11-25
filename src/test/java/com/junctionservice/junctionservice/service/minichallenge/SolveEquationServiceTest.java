package com.junctionservice.junctionservice.service.minichallenge;

import com.junctionservice.junctionservice.model.minichallenge.arithmetic.ArithmeticEquation;
import com.junctionservice.junctionservice.model.minichallenge.arithmetic.MathOperator;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class SolveEquationServiceTest {

    private SolveEquationService solveEquationService = new SolveEquationService();
    private MathOperatorMapper mathOperatorMapper = new MathOperatorMapper();

    @Before
    public void setChallenge() {
        ArithmeticEquation arithmeticEquation = new ArithmeticEquation();
        solveEquationService.setArithmeticEquationGame(arithmeticEquation);
        solveEquationService.setMathOperatorMapper(mathOperatorMapper);
    }

    @Test
    public void mapAdditionOperator() {
        BigDecimal x = mathOperatorMapper.operatorMapper(MathOperator.addition, 11, 11);
        assertEquals(new BigDecimal(22), x);
    }

    @Test
    public void mapSubtractOperator() {
        BigDecimal x = mathOperatorMapper.operatorMapper(MathOperator.subtraction, 22, 11);
        assertEquals(new BigDecimal(11), x);
    }

    @Test
    public void mapDivideOperator() {
        BigDecimal x = mathOperatorMapper.operatorMapper(MathOperator.division, 11, 2);
        assertEquals(new BigDecimal(5.50).setScale(2), x);
    }

    @Test
    public void mapMultiplyOperator() {
        BigDecimal x = mathOperatorMapper.operatorMapper(MathOperator.multiplication, 11, 2);
        assertEquals(new BigDecimal(22), x);
    }

}