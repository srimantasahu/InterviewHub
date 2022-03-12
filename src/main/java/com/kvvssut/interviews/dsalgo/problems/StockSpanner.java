package com.kvvssut.interviews.dsalgo.problems;

class StockSpanner {

    private int[][] priceSpan;
    private int length;

    public StockSpanner() {
        priceSpan = new int[10000][2];
        length = 0;
    }

    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();

        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(85));

    }

    public int next(int price) {
        int span = 1;
        int counter = length - 1;

        while (counter >= 0 && priceSpan[counter][0] <= price) {
            span += priceSpan[counter][1];
            counter -= priceSpan[counter][1];
        }

        priceSpan[length][0] = price;
        priceSpan[length][1] = span;
        length++;

        return span;
    }
}