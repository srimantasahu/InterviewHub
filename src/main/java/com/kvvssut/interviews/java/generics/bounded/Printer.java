package com.kvvssut.interviews.java.generics.bounded;

public class Printer<T extends ICartridge> {

    private T cartridge;

    public Printer(T cartridge) {
        this.cartridge = cartridge;
    }

    @Override
    public String toString() {
        System.out.println("toString - Fill percentage is: "
                + cartridge.getFillPercentage());
        return cartridge.toString();
    }

    public <U extends ICartridge> void printUsingCartridge(U cartridge,
                                                           String msg) {
        System.out.println("printUsingCartridge - Fill percentage is: "
                + cartridge.getFillPercentage());
        System.out.println(cartridge.toString() + " " + msg);
    }

}
