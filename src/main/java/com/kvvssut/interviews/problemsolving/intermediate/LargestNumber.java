package com.kvvssut.interviews.problemsolving.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 * Since the result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {

    public static void main(String[] args) {
        System.out.println(new LargestNumber().largestNumber(new int[]{3, 30, 34, 5, 9}));
    }

    //TODO : use quick sort
    public String largestNumber(int[] nums) {
        List<String> numsList = Arrays.stream(nums).mapToObj(String::valueOf)
                .sorted((n1, n2) -> (n2 + n1).compareTo(n1 + n2)).collect(Collectors.toList());

        StringBuilder result = new StringBuilder();
        for (String num : numsList) {
            result.append(num);
        }

        return result.charAt(0) == '0' ? "0" : result.toString();
    }

}
