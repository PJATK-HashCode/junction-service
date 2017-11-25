package com.junctionservice.junctionservice.service.minichallenge;

import com.junctionservice.junctionservice.model.minichallenge.arithmetic.ArithmeticEquation;
import com.junctionservice.junctionservice.model.minichallenge.arithmetic.MathOperator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArithmeticEquationServiceTest {

    private ArithmeticEquationService arithmeticEquationService = new ArithmeticEquationService();
    private ArithmeticEquation arithmeticEquation;

    @Before
    public void setChallenge(){
        arithmeticEquation = new ArithmeticEquation();
        arithmeticEquation.setId(0);
        arithmeticEquation.setName("ArithmeticEquation");
        arithmeticEquationService.setArithmeticEquationGame(arithmeticEquation);
    }

    @Test
    public void mapAdditionOperator(){
        long x = arithmeticEquationService.getMathOperatorMapper().operatorMapper(MathOperator.addition,11,11);
        assertEquals(22,x);
    }

    @Test
    public void mapSubtractOperator(){
        long x = arithmeticEquationService.getMathOperatorMapper().operatorMapper(MathOperator.substraction,22,11);
        assertEquals(11,x);
    }

    @Test
    public void mapDivideOperator(){
        long x = arithmeticEquationService.getMathOperatorMapper().operatorMapper(MathOperator.division,11,2);
        assertEquals(7.50,x,2);
    }

    @Test
    public void mapMultiplyOperator(){
        long x = arithmeticEquationService.getMathOperatorMapper().operatorMapper(MathOperator.multiplication,11,2);
        assertEquals(22,x);
    }
    @Test
    public void correctAnswer() throws Exception {
    }

}