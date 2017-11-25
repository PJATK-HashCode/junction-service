package com.junctionservice.junctionservice.model.minichallenge.colorpicker;

import com.junctionservice.junctionservice.model.minichallenge.IMiniChallenge;
import lombok.Data;

import java.util.*;

@Data
public class ColorPickerGame implements IMiniChallenge {

    private int id =3;
    private String name = "colorpicker";
    private Enum<Color> strColor;
    private Map<Color, String> optionalStrRepresentation;
    private Map<Color,String> properStrRepresention;
    private String properColorStr;

    @Override
    public int id() {
        return this.id();
    }

    @Override
    public String name() {
        return this.name();
    }

    private Map<Color,String> generateOptions(){
    return null;
    }
}
