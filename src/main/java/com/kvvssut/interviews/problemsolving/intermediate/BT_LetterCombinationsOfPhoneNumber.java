package com.kvvssut.interviews.problemsolving.intermediate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

    A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

    Input: digits = "23"
    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

*/

public class BT_LetterCombinationsOfPhoneNumber {

    private final static Map<Character, char[]> keyvals = new HashMap<>();

    static {
        keyvals.put('2', new char[]{'a', 'b', 'c'});
        keyvals.put('3', new char[]{'d', 'e', 'f'});
        keyvals.put('4', new char[]{'g', 'h', 'i'});
        keyvals.put('5', new char[]{'j', 'k', 'l'});
        keyvals.put('6', new char[]{'m', 'n', 'o'});
        keyvals.put('7', new char[]{'p', 'q', 'r', 's'});
        keyvals.put('8', new char[]{'t', 'u', 'v'});
        keyvals.put('9', new char[]{'w', 'x', 'y', 'z'});
    }


    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits.length() != 0) {
            recurse(digits, "", result);
        }

        return result;
    }


    private void recurse(String digits, String substr, List<String> result) {
        char[] chars = keyvals.get(digits.charAt(0));

        if (digits.length() == 1) {
            for (char ch : chars) {
                result.add(substr + ch);
            }
        } else {
            String remDigits = digits.substring(1);
            for (char ch : chars) {
                recurse(remDigits, substr + ch, result);
            }
        }
    }

}
