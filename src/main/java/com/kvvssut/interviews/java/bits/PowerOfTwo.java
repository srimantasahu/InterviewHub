package com.kvvssut.interviews.java.bits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PowerOfTwo {

    public static void main(String[] args) {

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));

            try {
                System.out.print("Enter a number to check is it power of 2: ");
                int input = Integer.parseInt(reader.readLine().trim());

                System.out.print(String.format("'%d' is power of 2 is '%s'.", input, isPowerOfTwo(input)));
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

    private static boolean isPowerOfTwo(int input) {

        if (input < 1) {
            return false;
        }

        byte counter = 0, var = 0;
        boolean output = true;

        while (input != 0) {
            var = (byte) (input & 1);

            if (var == 1) {
                counter++;

                if (counter == 2) {
                    output = false;
                    break;
                }
            }
            input >>= 1;
        }

        return output;
    }

}
