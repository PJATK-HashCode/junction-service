package com.junctionservice.junctionservice.service.minichallenge;

import com.junctionservice.junctionservice.service.minichallenge.colorpicker.ColorPickerService;
import org.springframework.beans.factory.annotation.Autowired;

public class MiniChallengeService {

    @Autowired
    private ArithmeticEquationService arithmeticEquationService;

    @Autowired
    private ColorPickerService colorPickerService;
}
