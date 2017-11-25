package com.junctionservice.junctionservice.model.minichallenge.picknumber;

import com.junctionservice.junctionservice.model.minichallenge.IMiniChallenge;
import lombok.Data;

@Data
public class PickNumber implements IMiniChallenge {

    private int id;
    private String name;



    @Override
    public int id() {
        return this.id;
    }

    @Override
    public String name() {
        return this.name;
    }
}
