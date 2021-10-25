package com.kvvssut.interviews.dsalgo.problems;

class FindComplement {

    public static void main(String[] args) {
        System.out.println(new FindComplement().findComplement(2));
    }

    public int findComplement(int num) {
        int comp = 0;

        for (int i = 0; num > 0; i++) {
            comp += (num % 2 == 0 ? Math.pow(2, i) : 0);
            num /= 2;
        }

        return comp;
    }
}