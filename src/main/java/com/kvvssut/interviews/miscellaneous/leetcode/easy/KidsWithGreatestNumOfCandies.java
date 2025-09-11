package com.kvvssut.interviews.miscellaneous.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class KidsWithGreatestNumOfCandies {

    public static void main(String[] args) {
        System.out.println(new KidsWithGreatestNumOfCandies().kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3));
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for (int candy : candies) {
            if (candy > maxCandies) maxCandies = candy;
        }

        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            result.add(candy + extraCandies >= maxCandies);
        }

        return result;
    }
}
