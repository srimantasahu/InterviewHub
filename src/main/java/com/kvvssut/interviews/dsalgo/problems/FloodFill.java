package com.kvvssut.interviews.dsalgo.problems;

class FloodFill {

    public static void main(String[] args) {
        int[][] image = {{0,0,0}, {0,1,1}};
        for (int[] img : image) {
            System.out.println(img[0] + " " + img[1] + " " + img[2]);
        }
        System.out.println();




        new FloodFill().floodFill(image, 1, 1, 1);

        for (int[] img : image) {
            System.out.println(img[0] + " " + img[1] + " " + img[2]);
        }

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (newColor != oldColor) {
            floodFill(image, sr, sc, oldColor, newColor);
        }
        return image;
    }

    private void floodFill(int[][] image, int sr, int sc, int oldColor, int newColor) {
        image[sr][sc] = newColor;
        if (sr > 0 && image[sr - 1][sc] == oldColor) {
            floodFill(image, sr - 1, sc, oldColor, newColor);
        }
        if (sr < image.length - 1 && image[sr + 1][sc] == oldColor) {
            floodFill(image, sr + 1, sc, oldColor, newColor);
        }
        if (sc > 0 && image[sr][sc - 1] == oldColor) {
            floodFill(image, sr, sc - 1, oldColor, newColor);
        }
        if (sc < image[0].length - 1 && image[sr][sc + 1] == oldColor) {
            floodFill(image, sr, sc + 1, oldColor, newColor);
        }
    }

}