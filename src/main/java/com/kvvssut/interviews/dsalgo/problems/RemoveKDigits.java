package com.kvvssut.interviews.dsalgo.problems;

import java.util.Stack;

class RemoveKDigits {

    public static void main(String[] args) {
        System.out.println(new RemoveKDigits().removeKdigits("9100432219", 6));
    }

    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }

        Stack<Character> numStack = new Stack<>();

        char ch = num.charAt(0);
        numStack.push(ch);

        int remCnt = 0;

        for (int i = 1; i < num.length(); i++) {
            ch = num.charAt(i);
            while (remCnt < k && !numStack.isEmpty() && ch < numStack.peek()) {
                numStack.pop();
                remCnt++;
            }
            numStack.push(ch);
        }

        while (remCnt < k) {
            numStack.pop();
            remCnt++;
        }

        StringBuilder result = new StringBuilder();

        while (!numStack.isEmpty()) {
            result.append(numStack.pop());
        }
        result.reverse();

        if (result.charAt(0) == '0') {
            int d = 1;
            while (d < result.length() - 1 && result.charAt(d) == '0') {
                d++;
            }
            result.delete(0, d);
        }

        if (result.length() == 0) {
            return "0";
        }

        return result.toString();
    }

}