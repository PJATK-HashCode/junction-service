package com.junctionservice.junctionservice.service.minichallenge;

import com.junctionservice.junctionservice.model.minichallenge.arithmetic.MathOperator;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

@Service
@Data
public class MathOperatorMapper {

    private String operator;

    public BigDecimal operatorMapper(MathOperator mathOperator, long x, long y) {
        switch (mathOperator) {
            case addition:
                operator = "+";
                return BigDecimal.valueOf(Math.addExact(x, y));
            case subtraction:
                operator = "-";
                return BigDecimal.valueOf(Math.subtractExact(x, y));
            case multiplication:
                operator = "*";
                return BigDecimal.valueOf(Math.multiplyExact(x, y));
            case division:
                operator = "/";
                BigDecimal x2 = new BigDecimal(x);
                BigDecimal y2 = new BigDecimal(y);
                return x2.divide(y2, 2, BigDecimal.ROUND_HALF_UP);
            default:
                return BigDecimal.valueOf(0);
        }
    }
}
