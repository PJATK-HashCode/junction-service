package com.junctionservice.junctionservice.service.minichallenge.colourpicker;

import com.junctionservice.junctionservice.model.minichallenge.colourpicker.Colour;
import com.junctionservice.junctionservice.model.minichallenge.colourpicker.ColourPickerGame;
import com.junctionservice.junctionservice.service.minichallenge.IMiniChallengeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Data
public class ColourPickerService implements IMiniChallengeService {


    private ColourPickerGame colourPickerGame;

    public ColourPickerService(){
        this.colourPickerGame = new ColourPickerGame();
    }

    @Override
    public int challengeId() {
        return colourPickerGame.id();
    }

    @Override
    public String challengeName() {
        return colourPickerGame.name();
    }

    @Override
    public String correctAnswer() {
       return colourPickerGame.getResult();
    }

    @Override
    public String question() {
        Map<String, String> colourStringMap = new HashMap<>();
        Colour randomColour = getRandomColour();
        Colour anotherRandomColour = getRandomColour();

        while(randomColour==anotherRandomColour){
            anotherRandomColour = getRandomColour();
        }

        colourStringMap.put(randomColour.toString(), anotherRandomColour.name());

        colourPickerGame.setResult(randomColour.name());
        return String.valueOf(colourStringMap);
    }


    @Override
    public List<String> possibleAnswers() {

        List<String> answers = new ArrayList<>();
        answers.add(colourPickerGame.getResult());
        String randomColour;

        while(answers.size()<=3){
            randomColour = getRandomColour().name();
            if(!answers.contains(randomColour)){
                answers.add(randomColour);
            }
        }
        Collections.shuffle(answers);
        return answers;
    }

    private Colour getRandomColour() {
        Random RANDOM = new Random();
         List<Colour> coloursList = Collections.unmodifiableList(Arrays.asList(Colour.values()));

        int randomRangeMax = Colour.values().length;

        return coloursList.get(RANDOM.nextInt((randomRangeMax)));
    }

}
