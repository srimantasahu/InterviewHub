package com.kvvssut.interviews.java.enumerations.basic;

import java.util.EnumMap;
import java.util.Map;

public class CustomEnumMap {

	private enum  Grades{
		O, E, A, B, C, D, F;
	};
	
	private void enumMapImpl() {
		
		Map<Grades, String> map = new EnumMap<Grades, String>(Grades.class);
		map.put(Grades.O, "Outstanding");	// only take enum values as keys
		
		
		Map<Grades, String> advancedMap = new EnumMap<Grades, String>(Grades.class);
		advancedMap.put(Grades.O, "Marks obtained is: " + Grades.O.name());
	}
}
