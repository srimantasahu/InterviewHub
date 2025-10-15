package com.kvvssut.interviews.miscellaneous.javabasics.collections.collectioninterface;

public final class CodingTask extends Task {

    private final String spec;

    public CodingTask(String spec) {
        this.spec = spec;
    }

    public String getSpec() {
        return spec;
    }

    @Override
    public String toString() {
        return "code " + spec;
    }

}
