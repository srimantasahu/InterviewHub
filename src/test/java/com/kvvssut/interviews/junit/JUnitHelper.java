package com.kvvssut.interviews.junit;

public class JUnitHelper {

	public static int returnInsideTryCatchWithoutExceptionsInTry() {
		try {
			return 1;
		} catch (Exception e) {
			return 2;
		} finally {
			System.out.println("Inside Finally");
		}
	}

	public static int returnInsideTryCatchWithExceptionsInTry() {
		try {
			if (1 == 1)
				throw new RuntimeException();

			return 1;
		} catch (Exception e) {
			System.out.println("Inside Exception");
			return 2;
		} finally {
			System.out.println("Inside Finally");
		}
	}

	public static int returnInsideTryCatchFinally() {
		try {
			return 1;
		} catch (Exception e) {
			return 2;
		} finally {
			return 3;
		}
	}

}
