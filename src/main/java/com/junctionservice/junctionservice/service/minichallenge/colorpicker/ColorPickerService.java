package com.junctionservice.junctionservice.service.minichallenge.colorpicker;

import com.junctionservice.junctionservice.model.minichallenge.colorpicker.ColorPickerGame;
import com.junctionservice.junctionservice.service.minichallenge.IMiniChallengeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ColorPickerService implements IMiniChallengeService {

    @Autowired
    ColorPickerGame colorPickerGame;

    @Override
    public int challengeId() {
        return this.colorPickerGame.getId();
    }

    @Override
    public String challengeName() {
        return this.colorPickerGame.getName();
    }

    @Override
    public String correctAnswer() {
       return colorPickerGame.getProperColorStr();
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
