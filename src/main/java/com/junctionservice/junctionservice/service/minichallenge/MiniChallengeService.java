package com.junctionservice.junctionservice.service.minichallenge;

import com.junctionservice.junctionservice.service.minichallenge.colourpicker.ColourPickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MiniChallengeService {

    @Autowired
    private SolveEquationService solveEquationService;
    private List<IMiniChallengeService> iMiniChallenges = new ArrayList<>();

    public MiniChallengeService() {
        iMiniChallenges.add(solveEquationService);
    }

    public IMiniChallengeService selectRandomChallenge() {
        Random randomize = new Random();
//        return iMiniChallenges.get(randomize.nextInt(iMiniChallenges.size()));
        return solveEquationService;
    }


    @Autowired
    private ColourPickerService colourPickerService;
}
