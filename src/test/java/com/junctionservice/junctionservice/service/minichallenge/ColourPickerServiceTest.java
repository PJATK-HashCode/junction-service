package com.junctionservice.junctionservice.service.minichallenge;

import com.junctionservice.junctionservice.model.minichallenge.arithmetic.ArithmeticEquation;
import com.junctionservice.junctionservice.model.minichallenge.colourpicker.Colour;
import com.junctionservice.junctionservice.model.minichallenge.colourpicker.ColourPickerGame;
import com.junctionservice.junctionservice.service.minichallenge.colourpicker.ColourPickerService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class ColourPickerServiceTest {
   private ColourPickerService colourPickerService = new ColourPickerService();

   @Before
   public void setChallenge() {
       ColourPickerGame game = new ColourPickerGame();
       colourPickerService.setColourPickerGame(game);
   }

   @Test
   public void dsdsd(){
       System.out.println(colourPickerService.question());
       System.out.println(colourPickerService.getColourPickerGame().getResult());
   }

   @Test
   public void checkIfCorrectAnswerIncluded(){
      assertTrue(colourPickerService.possibleAnswers()
              .contains(colourPickerService.correctAnswer()));
       System.out.println(colourPickerService.correctAnswer());
       System.out.println(colourPickerService.possibleAnswers());
       System.out.println(colourPickerService.getColourPickerGame().getResult());
   }

   @Test
    public void checkIfCorrectAnswerIsAccepted(){
       colourPickerService.question();
       colourPickerService.possibleAnswers();
       System.out.println(colourPickerService.question());
       System.out.println(colourPickerService.possibleAnswers());
       System.out.println(colourPickerService.correctAnswer());
       System.out.println(colourPickerService.getColourPickerGame().getResult());
   }
}
