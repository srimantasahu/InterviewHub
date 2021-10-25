package com.kvvssut.interviews.dsalgo.problems;

class RandomPickWithWeight {

    int[] weights;
    int size = 0;
    int total = 0;

    public RandomPickWithWeight(int[] w) {
        weights = w;
        size = weights.length;
        for (int i = 1; i < size; i++) {
            weights[i] += weights[i - 1];
        }
        total = weights[size - 1];
    }

    public static void main(String[] args) {
        RandomPickWithWeight obj = new RandomPickWithWeight(new int[]{1, 3, 4});
        System.out.println(obj.pickIndex());
        System.out.println(obj.pickIndex());
        System.out.println(obj.pickIndex());
        System.out.println(obj.pickIndex());
        System.out.println(obj.pickIndex());
    }

    public int pickIndex() {
        double rand = Math.random() * total;

        int low = 0;
        int high = size - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (rand > weights[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

}