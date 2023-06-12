package com.kvvssut.interviews.problemsolving.advanced;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new TrappingRainWater().trap(height));
    }

    public int trap(int[] height) {
        int lmax = 0, rmax = 0, qty = 0;
        int[] lmaxHeight = new int[height.length], rmaxHeight = new int[height.length];

        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > lmax) {
                lmax = height[i - 1];
            }
            lmaxHeight[i] = lmax;
        }

        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i + 1] > rmax) {
                rmax = height[i + 1];
            }
            rmaxHeight[i] = rmax;
        }

        for (int i = 0; i < height.length; i++) {
            int low = Math.min(lmaxHeight[i], rmaxHeight[i]);
            if (low > height[i]) {
                qty += (low - height[i]);
            }
        }

        return qty;
    }

}
