package com.kvvssut.interviews.dsalgo.datastructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MicroAndQueue {

    private static int QUEUE_SIZE = 0;
    private static int front = 0, rear = 0, count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        QUEUE_SIZE = Integer.parseInt(line);

        int queue[] = new int[QUEUE_SIZE];
        for (int i = 0; i < QUEUE_SIZE; i++) {
            line = br.readLine();
            if (line.charAt(0) == 'D') {
                dequeue(queue);
            } else {
                enqueue(queue, Integer.parseInt(line.split(" ")[1]));
            }
        }
    }

    private static void enqueue(int[] queue, int item) {
        queue[rear] = item;
        rear = (rear + 1) % QUEUE_SIZE;
        count++;
        System.out.println(count);
    }

    private static void dequeue(int[] queue) {
        if (count == 0) {
            System.out.println("-1 0");
        } else {
            int item = queue[front];
            queue[front] = 0;
            front = (front + 1) % QUEUE_SIZE;
            count--;

            System.out.println(item + " " + count);
        }
    }

}
