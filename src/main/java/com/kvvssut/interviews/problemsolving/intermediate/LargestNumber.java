package com.kvvssut.interviews.problemsolving.intermediate;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 * Since the result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {

    public static void main(String[] args) {
        System.out.println(new LargestNumber().largestNumber(new int[] {3,30,34,5,9}));
    }

    public String largestNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                break;
            }
            if (i == nums.length - 1) {
                return "0";
            }
        }

        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        numsList.sort((n1, n2) -> (n2 + "" + n1).compareTo(n1 + "" + n2));

        StringBuilder result = new StringBuilder();
        for (int num : numsList) {
            result.append(num);
        }

        return result.toString();
    }

}
