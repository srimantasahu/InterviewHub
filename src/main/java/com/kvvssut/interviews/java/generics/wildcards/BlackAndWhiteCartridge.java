package com.kvvssut.interviews.java.generics.wildcards;

public class BlackAndWhiteCartridge implements ICartridge {

    @Override
    public String toString() {
        return "balck and white";
    }

    @Override
    public int getFillPercentage() {
        return 50;
    }

}
