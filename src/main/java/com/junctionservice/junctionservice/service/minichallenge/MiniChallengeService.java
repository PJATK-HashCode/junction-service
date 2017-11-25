package com.junctionservice.junctionservice.service.minichallenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiniChallengeService {

    @Autowired
    private SolveEquationService solveEquationService;

}
