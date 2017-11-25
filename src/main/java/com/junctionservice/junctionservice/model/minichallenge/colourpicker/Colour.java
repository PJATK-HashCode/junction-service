package com.junctionservice.junctionservice.model.minichallenge.colourpicker;

public enum Colour {
    GREEN ("#009933"),
    RED ("#ff0000") ,
    PINK("#ff0066") ,
    BLUE("#0000ff") ,
    BLACK("#000000") ,
    ORANGE("#ff9900") ,
    PURPLE("#993399") ,
    BROWN("#996633") ,
    GREY("#696969") ;

    Colour(String val) {
        this.val = val;
    }

    private final String val;

    @Override
    public String toString() {
        return val;
    }
}
