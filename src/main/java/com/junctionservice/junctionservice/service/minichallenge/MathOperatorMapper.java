package com.junctionservice.junctionservice.service.minichallenge;

import com.junctionservice.junctionservice.model.minichallenge.arithmetic.MathOperator;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class MathOperatorMapper {

    public long operatorMapper(MathOperator mathOperator, long x, long y) {
        switch (mathOperator) {
            case addition:
                return Math.addExact(x, y);
            case substraction:
                return Math.subtractExact(x, y);
            case multiplication:
                return Math.multiplyExact(x, y);
            case division:
                BigDecimal convertedValue = new BigDecimal(Math.floorDiv(x, y));
                convertedValue = convertedValue.setScale(2, RoundingMode.HALF_UP);
                return convertedValue.longValue();
            default:
                return 0;
        }
    }
}
