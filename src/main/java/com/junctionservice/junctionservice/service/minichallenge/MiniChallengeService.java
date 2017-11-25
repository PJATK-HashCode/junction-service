package com.junctionservice.junctionservice.service.minichallenge;

import com.junctionservice.junctionservice.model.minichallenge.IMiniChallenge;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MiniChallengeService {

    @Autowired
    private SolveEquationService solveEquationService;
    private List<IMiniChallengeService> iMiniChallenges = new ArrayList<>();

    public MiniChallengeService() {
        iMiniChallenges.add(solveEquationService);
    }

    public IMiniChallengeService selectRandomChallenge() {
        Random randomize = new Random();
        return iMiniChallenges.get(randomize.nextInt(iMiniChallenges.size()));
    }


}
