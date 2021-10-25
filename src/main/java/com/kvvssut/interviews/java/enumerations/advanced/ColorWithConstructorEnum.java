package com.kvvssut.interviews.java.enumerations.advanced;

public enum ColorWithConstructorEnum implements IColors {

	RED("Red"), BLUE("Blue"), GREEN("Green");

	private String colorText;

	private ColorWithConstructorEnum(String colorText) { // public - Illegal
															// modifier for the
															// enum constructor;
															// only private is
															// permitted.
		this.colorText = colorText;
	}

	public String getColorText() {
		return colorText;
	}

	@Override
	public int getFillPercentage() {
		int fillPercentage = 0;

		if (this == RED) {
			fillPercentage = 75;
		} else if (this == BLUE) {
			fillPercentage = 60;
		} else if (this == GREEN) {
			fillPercentage = 95;
		}

		return fillPercentage;
	}

}
