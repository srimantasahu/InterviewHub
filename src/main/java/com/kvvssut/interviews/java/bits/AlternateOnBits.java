package com.kvvssut.interviews.java.bits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlternateOnBits {

    public static void main(String[] args) {

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));

            try {
                System.out.print("Enter a number to check its alternate on/off: ");
                int input = Integer.parseInt(reader.readLine().trim());

                System.out.print(String.format("'%d' alternate on/off is '%s'.", input, isAlternateOn(input)));
            } catch (NumberFormatException | IOException exception) {
                exception.printStackTrace();
            }

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }

    private static boolean isAlternateOn(int input) {

        int num = 1;

        do {
            num *= 2;
        } while (num < input);

        boolean output = false;

        if ((input + (input >> 1)) == num - 1) {
            output = true;
        }

        return output;
    }

}
