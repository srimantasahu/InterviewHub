package com.kvvssut.interviews.javabasics.generics.bounded;

public class ColorCartridge implements ICartridge {

    @Override
    public String toString() {
        return "color";
    }

    @Override
    public int getFillPercentage() {
        return 97;
    }

}
