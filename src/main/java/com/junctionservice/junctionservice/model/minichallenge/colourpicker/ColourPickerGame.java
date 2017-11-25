package com.junctionservice.junctionservice.model.minichallenge.colourpicker;

import com.junctionservice.junctionservice.model.minichallenge.IMiniChallenge;
import lombok.Data;

import java.util.*;

@Data
public class ColourPickerGame implements IMiniChallenge {

    private final int id =2;
    private final String name = "colourpicker";
    private String result;

    @Override
    public int id() {
        return this.id();
    }

    @Override
    public String name() {
        return this.name();
    }

}
